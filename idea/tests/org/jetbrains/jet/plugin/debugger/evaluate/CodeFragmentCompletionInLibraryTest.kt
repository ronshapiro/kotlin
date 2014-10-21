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

package org.jetbrains.jet.plugin.debugger.evaluate

import org.jetbrains.jet.completion.AbstractJvmBasicCompletionTest
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiManager
import org.jetbrains.jet.lang.psi.JetFile
import org.jetbrains.jet.lang.psi.JetFunction
import org.jetbrains.jet.lang.psi.JetPsiFactory
import org.jetbrains.jet.completion.util.testCompletion
import org.jetbrains.jet.plugin.project.TargetPlatform
import com.intellij.codeInsight.completion.CompletionType
import org.jetbrains.jet.plugin.JdkAndMockLibraryProjectDescriptor
import org.jetbrains.jet.plugin.PluginTestCaseBase
import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.roots.ContentEntry
import java.io.File
import com.intellij.openapi.roots.OrderRootType
import com.intellij.openapi.vfs.VirtualFile

private val LIBRARY_SRC_PATH = PluginTestCaseBase.getTestDataPathBase() + "/completion/codeFragmentInLibrarySource/customLibrary/"

public class CodeFragmentCompletionInLibraryTest : AbstractJvmBasicCompletionTest() {

    override fun getProjectDescriptor() = object: JdkAndMockLibraryProjectDescriptor(LIBRARY_SRC_PATH, true) {
        override fun configureModule(module: Module, model: ModifiableRootModel, contentEntry: ContentEntry?) {
            super.configureModule(module, model, contentEntry)

            val library = model.getModuleLibraryTable().getLibraryByName(JdkAndMockLibraryProjectDescriptor.LIBRARY_NAME)
            val modifiableModel = library.getModifiableModel()

            modifiableModel.addRoot(findLibrarySourceDir(), OrderRootType.SOURCES)
            modifiableModel.commit()
        }
    }

    public fun testCompletionInCustomLibrary() {
        testCompletionInLibraryCodeFragment("<caret>", "EXIST: parameter")
    }

    public fun testSecondCompletionInCustomLibrary() {
        testCompletionInLibraryCodeFragment("Sh<caret>", "EXIST: ShortRange", "EXIST: Short", "INVOCATION_COUNT: 2")
    }

    public fun testExtensionCompletionInCustomLibrary() {
        testCompletionInLibraryCodeFragment("3.extOn<caret>", "EXIST: extOnInt")
    }

    private fun testCompletionInLibraryCodeFragment(fragmentText: String, vararg completionDirectives: String) {
        setupFixtureByCodeFragment(fragmentText)
        val directives = completionDirectives.map { "//$it" }.joinToString(separator = "\n")
        testCompletion(directives, TargetPlatform.JVM, {
            myFixture.complete(CompletionType.BASIC)
        })
    }

    private fun setupFixtureByCodeFragment(fragmentText: String) {
        val sourceFile = findLibrarySourceDir().findChild("customLibrary.kt")
        val jetFile = PsiManager.getInstance(getProject()).findFile(sourceFile) as JetFile
        val fooFunctionFromLibrary = jetFile.getDeclarations().first() as JetFunction
        val codeFragment = JetPsiFactory(fooFunctionFromLibrary).createExpressionCodeFragment(
                fragmentText,
                KotlinCodeFragmentFactory.getContextElement(fooFunctionFromLibrary.getBodyExpression())
        )
        myFixture.configureFromExistingVirtualFile(codeFragment.getVirtualFile())
    }

    private fun findLibrarySourceDir(): VirtualFile {
        return LocalFileSystem.getInstance().findFileByIoFile(File(LIBRARY_SRC_PATH))!!
    }
}