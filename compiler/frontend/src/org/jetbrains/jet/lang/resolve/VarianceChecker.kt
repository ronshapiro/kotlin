/*
 * Copyright 2010-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.lang.resolve.varianceChecker

import org.jetbrains.jet.lang.descriptors.ClassDescriptor
import org.jetbrains.jet.lang.diagnostics.Errors
import org.jetbrains.jet.lang.descriptors.TypeParameterDescriptor
import org.jetbrains.jet.lang.types.Variance
import org.jetbrains.jet.lang.types.checker.TypeCheckingProcedure.EnrichedProjectionKind.*
import org.jetbrains.jet.lang.types.checker.TypeCheckingProcedure.*
import org.jetbrains.jet.lang.diagnostics.Diagnostic
import org.jetbrains.jet.lang.descriptors.Visibilities
import org.jetbrains.jet.lang.resolve.BindingTrace
import org.jetbrains.jet.lang.resolve.typeBinding.TypeBinding
import com.intellij.psi.PsiElement
import org.jetbrains.jet.lang.resolve.typeBinding.createTypeBinding
import org.jetbrains.jet.lang.resolve.typeBinding.createTypeBindingForReturnType
import org.jetbrains.jet.lang.psi.JetCallableDeclaration
import org.jetbrains.jet.lang.descriptors.CallableDescriptor
import org.jetbrains.jet.lang.resolve.TopDownAnalysisContext
import org.jetbrains.jet.lang.types.JetType
import org.jetbrains.jet.lang.psi.JetClass
import org.jetbrains.jet.lang.psi.JetTypeReference
import org.jetbrains.jet.lang.types.Variance.*
import org.jetbrains.jet.lang.diagnostics.DiagnosticSink


class VarianceChecker(private val trace: BindingTrace) {

    fun process(c: TopDownAnalysisContext) {
        check(c)
    }

    fun check(c: TopDownAnalysisContext) {
        checkFunctions(c)
        checkProperties(c)
        checkClasses(c)
    }

    private fun checkClasses(c: TopDownAnalysisContext) {
        for (jetClassOrObject in c.getDeclaredClasses()!!.keySet()) {
            if (jetClassOrObject is JetClass)
                checkClass(jetClassOrObject)
        }
    }

    private fun checkClass(jetClass: JetClass) {
        for (specifier in jetClass.getDelegationSpecifiers()) {
            specifier.getTypeReference()?.checkTypePosition(trace, OUT_VARIANCE, trace)
        }
    }

    private fun checkFunctions(c: TopDownAnalysisContext) {
        for ((declaration, descriptor) in c.getFunctions().entrySet()) {
            checkCallableDeclaration(declaration, descriptor, OUT_VARIANCE)
        }
    }

    private fun checkProperties(c: TopDownAnalysisContext) {
        for ((declaration, descriptor) in c.getProperties().entrySet()) {
            checkCallableDeclaration(declaration, descriptor, if (descriptor.isVar()) INVARIANT else OUT_VARIANCE)
        }
    }
    
    private fun checkCallableDeclaration(declaration: JetCallableDeclaration, descriptor: CallableDescriptor, returnTypePosition: Variance) {
        if (descriptor.getContainingDeclaration() !is ClassDescriptor) return

        val diagnosticSink = PrivateToThisDiagnosticSink(descriptor, trace)
        declaration.checkReceiver(trace, diagnosticSink)
        declaration.checkReturnType(trace, returnTypePosition, diagnosticSink)
        declaration.checkTypeParameters(trace, diagnosticSink)

        val jetParameterList = declaration.getValueParameterList()
        if (jetParameterList != null) {
            for (parameter in jetParameterList.getParameters()) {
                parameter.getTypeReference()?.checkTypePosition(trace, IN_VARIANCE, diagnosticSink)
            }
        }
        //todo diagnosticSink.privateToThis
    }

    private class PrivateToThisDiagnosticSink(
            private val descriptor: CallableDescriptor,
            private val trace: BindingTrace
    ): DiagnosticSink {
        var privateToThis = false

        override fun report(diagnostic: Diagnostic): Unit
                = if (descriptor.getVisibility() != Visibilities.PRIVATE) trace.report(diagnostic)
                    else privateToThis = true
    }
}

class VarianceConflictDiagnosticData(
        val containingType: JetType,
        val typeParameter: JetType,
        val declarationPosition: String,
        val useSidePosition: String
)

private fun JetCallableDeclaration.checkReceiver(trace: BindingTrace, diagnosticSink: DiagnosticSink)
        = getReceiverTypeReference()?.checkTypePosition(trace, IN_VARIANCE, diagnosticSink)

private fun JetCallableDeclaration.checkReturnType(trace: BindingTrace, returnTypePosition: Variance, diagnosticSink: DiagnosticSink)
        = createTypeBindingForReturnType(trace)?.checkTypePosition(returnTypePosition, diagnosticSink)

private fun JetCallableDeclaration.checkTypeParameters(trace: BindingTrace, diagnosticSink: DiagnosticSink) {
    for (typeParameter in getTypeParameters()) {
        typeParameter.getExtendsBound()?.checkTypePosition(trace, IN_VARIANCE, diagnosticSink)
    }
    for (typeConstraint in getTypeConstraints()) {
        typeConstraint.getBoundTypeReference()?.checkTypePosition(trace, IN_VARIANCE, diagnosticSink)
    }
}

private fun Variance.allowsPosition(position: Variance)
        = when(position) {
    IN_VARIANCE -> allowsInPosition()
    OUT_VARIANCE -> allowsOutPosition()
    INVARIANT -> allowsInPosition() && allowsOutPosition()
}

private fun JetTypeReference.checkTypePosition(trace: BindingTrace, position: Variance, diagnosticSink: DiagnosticSink)
        = createTypeBinding(trace)?.checkTypePosition(position, diagnosticSink)

private fun TypeBinding<PsiElement>.checkTypePosition(position: Variance, diagnosticSink: DiagnosticSink)
        = checkTypePosition(jetType, position, diagnosticSink)

private fun TypeBinding<PsiElement>.checkTypePosition(containingType: JetType, position: Variance, diagnosticSink: DiagnosticSink) {
    val classifierDescriptor = jetType.getConstructor().getDeclarationDescriptor()
    if (classifierDescriptor is TypeParameterDescriptor) {
        val declarationVariance = classifierDescriptor.getVariance()
        if (!declarationVariance.allowsPosition(position)) {
            diagnosticSink.report(
                    Errors.TYPE_PARAMETER_VARIANCE_CONFLICT.on(
                            psiElement,
                            VarianceConflictDiagnosticData(containingType, jetType, declarationVariance.asPositionName(), position.asPositionName())
                    )
            )
        }
        return
    }

    for (argumentBinding in getArgumentBindings()) {
        if (argumentBinding == null || argumentBinding.typeParameterDescriptor == null) continue

        val projectionKind = getEffectiveProjectionKind(argumentBinding.typeParameterDescriptor!!, argumentBinding.typeProjection)
        val newPosition = when (projectionKind) {
            OUT -> position
            IN -> position.opposite()
            INV -> INVARIANT
            STAR -> null // see Errors.CONFLICTING_PROJECTION
        }
        if (newPosition != null) {
            argumentBinding.typeBinding.checkTypePosition(containingType, newPosition, diagnosticSink)
        }
    }
}

private fun Variance.asPositionName()
        = when(this) {
    INVARIANT -> "invariant"
    else -> getLabel()
}

