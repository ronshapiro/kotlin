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

package org.jetbrains.jet.lang.resolve.typeBinding

import org.jetbrains.jet.lang.types.JetType
import org.jetbrains.jet.lang.descriptors.TypeParameterDescriptor
import com.intellij.psi.PsiElement
import org.jetbrains.jet.lang.psi.JetTypeElement
import org.jetbrains.jet.lang.psi.JetCallableDeclaration
import org.jetbrains.jet.lang.resolve.BindingTrace
import org.jetbrains.jet.lang.resolve.BindingContext
import org.jetbrains.jet.lang.psi.JetTypeReference
import java.util.AbstractList
import org.jetbrains.jet.lang.types.TypeProjection
import org.jetbrains.jet.lang.descriptors.CallableDescriptor
import org.jetbrains.jet.lang.types.TypeProjectionImpl


trait TypeBinding<out P : PsiElement> {
    val psiElement: P
    val jetType: JetType
    fun getArgumentBindings(): List<TypeArgumentBinding<P>?>
}

trait TypeArgumentBinding<out P: PsiElement> {
    val typeProjection: TypeProjection
    val typeParameterDescriptor: TypeParameterDescriptor?
    val typeBinding: TypeBinding<P>
}

fun JetTypeReference.createTypeBinding(trace: BindingTrace): TypeBinding<JetTypeElement>? {
    val jetType = trace[BindingContext.TYPE, this]
    val psiElement = getTypeElement()
    if (jetType == null || psiElement == null)
        return null
    else
        return ExplicitTypeBinding(trace, psiElement, jetType)
}

fun JetCallableDeclaration.createTypeBindingForReturnType(trace: BindingTrace): TypeBinding<PsiElement>?  {
    val jetTypeReference = getTypeReference()
    if (jetTypeReference != null)
        return jetTypeReference.createTypeBinding(trace)

    val descriptor = trace[BindingContext.DECLARATION_TO_DESCRIPTOR, this]
    if (descriptor !is CallableDescriptor) return null;

    return descriptor.getReturnType()?.let { SimpleTypeBinding(trace, this, it) }
}

private class TypeArgumentBindingImpl<out P: PsiElement>(
        override val typeProjection: TypeProjection,
        override val typeParameterDescriptor: TypeParameterDescriptor?,
        override val typeBinding: TypeBinding<P>
) : TypeArgumentBinding<P>

private class ExplicitTypeBinding(
        private val trace: BindingTrace,
        override val psiElement: JetTypeElement,
        override val jetType: JetType
) : TypeBinding<JetTypeElement> {
    private val constructor = jetType.getConstructor()
    private val typeArguments = psiElement.getTypeArgumentsAsTypes()

    private val isErrorBinding = run {
        val sizeIsEqual = constructor.getParameters().size == jetType.getArguments().size
                        && constructor.getParameters().size == typeArguments.size
        jetType.isError() || !sizeIsEqual
    }

    override fun getArgumentBindings(): List<TypeArgumentBinding<JetTypeElement>?> {
        return object : AbstractList<TypeArgumentBinding<JetTypeElement>?>() {
            override fun size() = typeArguments.size

            override fun get(index: Int): TypeArgumentBinding<JetTypeElement>? {
                val jetTypeReference = psiElement.getTypeArgumentsAsTypes()[index]
                val jetTypeElement = jetTypeReference?.getTypeElement()
                if (jetTypeElement == null)
                    return null;

                if (isErrorBinding) {
                    val nextJetType = trace[BindingContext.TYPE, jetTypeReference]
                    if (nextJetType == null)
                        return null;
                    return TypeArgumentBindingImpl(
                            TypeProjectionImpl(nextJetType),
                            null,
                            ExplicitTypeBinding(trace, jetTypeElement, nextJetType)
                    )
                }

                return TypeArgumentBindingImpl(
                        jetType.getArguments()[index],
                        constructor.getParameters()[index],
                        ExplicitTypeBinding(trace, jetTypeElement, jetType.getArguments()[index].getType())
                )
            }
        }
    }
}

private class SimpleTypeBinding<out P : PsiElement>(
        private val trace: BindingTrace,
        override val psiElement: P,
        override val jetType: JetType
): TypeBinding<P> {
    private val constructor = jetType.getConstructor()
    private val typeArguments = jetType.getArguments()
    private val isErrorBinding = jetType.isError() || constructor.getParameters().size != typeArguments.size

    override fun getArgumentBindings(): List<TypeArgumentBinding<P>?> {
        return object : AbstractList<TypeArgumentBinding<P>?>() {
            override fun size() = typeArguments.size

            override fun get(index: Int): TypeArgumentBinding<P>? {
                val typeProjection = typeArguments[index]
                return TypeArgumentBindingImpl(
                        typeProjection,
                        if (isErrorBinding) null else constructor.getParameters()[index],
                        SimpleTypeBinding(trace, psiElement, typeProjection.getType())
                )
            }
        }
    }
}

