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

package org.jetbrains.jet.types

import org.jetbrains.jet.JetLiteFixture
import org.jetbrains.jet.ConfigurationKind
import org.jetbrains.jet.JetTestUtils
import java.io.File
import org.junit.Assert.*
import org.jetbrains.jet.lang.resolve.BindingTraceContext
import org.jetbrains.jet.lang.resolve.typeBinding.*
import org.jetbrains.jet.lang.types.JetType
import org.jetbrains.jet.renderer.DescriptorRenderer
import org.jetbrains.jet.lang.descriptors.TypeParameterDescriptor
import org.jetbrains.jet.lang.resolve.lazy.JvmResolveUtil
import org.jetbrains.jet.lang.psi.JetCallableDeclaration

open class AbstractJetTypeBindingTest : JetLiteFixture() {
    private val externalFile = "compiler/testData/type-binding-test.kt"

    override fun createEnvironment() = createEnvironmentWithMockJdk(ConfigurationKind.ALL)

    protected fun doTest(path: String) {
        val jetExternalFile = JetTestUtils.loadJetFile(getProject(), File(externalFile))

        val testFile = File(path)
        val testKtFile = JetTestUtils.loadJetFile(getProject(), testFile)

        val bindingTrace = BindingTraceContext.createTraceableBindingTrace()
        JvmResolveUtil.analyzeFilesWithJavaIntegration(getProject(), bindingTrace, listOf(testKtFile, jetExternalFile), {true})

        val declarations = testKtFile.getDeclarations()
        assertEquals("This file should contain only one declaration", 1, declarations.size)
        val testDeclaration = declarations.first as JetCallableDeclaration

        val typeBinding = testDeclaration.createTypeBindingForReturnType(bindingTrace)

        JetTestUtils.assertEqualsToFile(
                testFile,
                StringBuilder {
                    append(testDeclaration.getText()).append("\n")
                    append("/*\n")

                    append(typeBinding.toStr())

                    append("\n*/")
                }.toString()
        )
    }

    private fun JetType.toStr() = DescriptorRenderer.SHORT_NAMES_IN_TYPES.renderType(this)
    private fun TypeBinding<*>?.toStr(): String {
        val strBuilder = StrBuilder()
        strBuilder.toStr(this)
        return strBuilder.toString()
    }
    private fun TypeParameterDescriptor?.toStr() = if(this == null) "null" else DescriptorRenderer.SHORT_NAMES_IN_TYPES.render(this)


    private fun StrBuilder.toStr(argument: TypeArgumentBinding<*>?) {
        if (argument == null) {
            addLine("null")
            return
        }
        addLine("typeParameter: ${argument.typeParameterDescriptor.toStr()}")

        val projection = argument.typeProjection.getProjectionKind().getLabel().let {
            if (it.length != 0) "$it "
            else ""
        }

        addLine("typeProjection: ${projection}${argument.typeProjection.getType().toStr()}")
        toStr(argument.typeBinding)
    }

    private fun StrBuilder.toStr(binding: TypeBinding<*>?) {
        if(binding == null) {
            addLine("null")
            return
        }

        addLine("psi: ${binding.psiElement.getText()}")
        addLine("type: ${binding.jetType.toStr()}")

        nextLevel {
            for (argument in binding.getArgumentBindings()) {
                toStr(argument)
            }
        }
    }

    private class StrBuilder(val sb: StringBuilder = StringBuilder(), val offset: Int = 0, val offsetInc: Int = 4) : Appendable by sb {
        var lineWasStarted = false

        fun startNewLine(): StrBuilder {
            if (sb.size > 0)
                sb.append("\n")
            sb.append(" ".repeat(offset))
            lineWasStarted = true
            return this
        }

        fun addLine(s: String) {
            startNewLine().append(s)
        }

        fun nextLevel(f: StrBuilder.() -> Unit) {
            if (!lineWasStarted) startNewLine()

            append(" {")
            val prevSize = sb.size

            StrBuilder(sb, offset + offsetInc, offsetInc).f()

            if (sb.size > prevSize) startNewLine().append("}")
            else append("}")
        }

        override fun toString(): String {
            return sb.toString()
        }
    }
}
