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

package org.jetbrains.jet.formatter;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;
import java.util.regex.Pattern;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;

import org.jetbrains.jet.formatter.AbstractJetTypingIndentationTestBase;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@InnerTestClasses({JetTypingIndentationTestBaseGenerated.DirectSettings.class, JetTypingIndentationTestBaseGenerated.InvertedSettings.class})
public class JetTypingIndentationTestBaseGenerated extends AbstractJetTypingIndentationTestBase {
    @TestMetadata("idea/testData/indentationOnNewline")
    @InnerTestClasses({DirectSettings.Script.class})
    public static class DirectSettings extends AbstractJetTypingIndentationTestBase {
        @TestMetadata("AfterCatch.after.kt")
        public void testAfterCatch() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/AfterCatch.after.kt");
        }
        
        @TestMetadata("AfterClassNameBeforeFun.after.kt")
        public void testAfterClassNameBeforeFun() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/AfterClassNameBeforeFun.after.kt");
        }
        
        @TestMetadata("AfterFinally.after.kt")
        public void testAfterFinally() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/AfterFinally.after.kt");
        }
        
        @TestMetadata("AfterImport.after.kt")
        public void testAfterImport() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/AfterImport.after.kt");
        }
        
        @TestMetadata("AfterTry.after.kt")
        public void testAfterTry() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/AfterTry.after.kt");
        }
        
        public void testAllFilesPresentInDirectSettings() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage",
                                                         new File("idea/testData/indentationOnNewline"),
                                                         Pattern.compile("^([^\\.]+)\\.after\\.kt.*$"), true);
        }
        
        @TestMetadata("ConsecutiveCallsAfterDot.after.kt")
        public void testConsecutiveCallsAfterDot() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/ConsecutiveCallsAfterDot.after.kt");
        }
        
        @TestMetadata("ConsecutiveCallsInSaeCallsMiddle.after.kt")
        public void testConsecutiveCallsInSaeCallsMiddle() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/ConsecutiveCallsInSaeCallsMiddle.after.kt");
        }
        
        @TestMetadata("ConsecutiveCallsInSafeCallsEnd.after.kt")
        public void testConsecutiveCallsInSafeCallsEnd() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/ConsecutiveCallsInSafeCallsEnd.after.kt");
        }
        
        @TestMetadata("DoInFun.after.kt")
        public void testDoInFun() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/DoInFun.after.kt");
        }
        
        @TestMetadata("EmptyParameters.after.kt")
        public void testEmptyParameters() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/EmptyParameters.after.kt");
        }
        
        @TestMetadata("For.after.kt")
        public void testFor() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/For.after.kt");
        }
        
        @TestMetadata("FunctionBlock.after.kt")
        public void testFunctionBlock() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/FunctionBlock.after.kt");
        }
        
        @TestMetadata("FunctionWithInference.after.kt")
        public void testFunctionWithInference() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/FunctionWithInference.after.kt");
        }
        
        @TestMetadata("If.after.kt")
        public void testIf() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/If.after.kt");
        }
        
        @TestMetadata("InBinaryExpressionInMiddle.after.kt")
        public void testInBinaryExpressionInMiddle() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/InBinaryExpressionInMiddle.after.kt");
        }
        
        @TestMetadata("InBinaryExpressionUnfinished.after.kt")
        public void testInBinaryExpressionUnfinished() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/InBinaryExpressionUnfinished.after.kt");
        }
        
        @TestMetadata("InBinaryExpressionsBeforeCloseParenthesis.after.kt")
        public void testInBinaryExpressionsBeforeCloseParenthesis() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/InBinaryExpressionsBeforeCloseParenthesis.after.kt");
        }
        
        @TestMetadata("InExpressionsParentheses.after.kt")
        public void testInExpressionsParentheses() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/InExpressionsParentheses.after.kt");
        }
        
        @TestMetadata("InExpressionsParenthesesBeforeOperand.after.kt")
        public void testInExpressionsParenthesesBeforeOperand() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/InExpressionsParenthesesBeforeOperand.after.kt");
        }
        
        @TestMetadata("NotFirstParameter.after.kt")
        public void testNotFirstParameter() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/NotFirstParameter.after.kt");
        }
        
        @TestMetadata("PropertyWithInference.after.kt")
        public void testPropertyWithInference() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/PropertyWithInference.after.kt");
        }
        
        @TestMetadata("SettingAlignMultilineParametersInCalls.after.kt")
        public void testSettingAlignMultilineParametersInCalls() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/SettingAlignMultilineParametersInCalls.after.kt");
        }
        
        @TestMetadata("While.after.kt")
        public void testWhile() throws Exception {
            doNewlineTest("idea/testData/indentationOnNewline/While.after.kt");
        }
        
        @TestMetadata("idea/testData/indentationOnNewline/script")
        public static class Script extends AbstractJetTypingIndentationTestBase {
            public void testAllFilesPresentInScript() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("idea/testData/indentationOnNewline/script"), Pattern.compile("^([^\\.]+)\\.after\\.kt.*$"), true);
            }
            
            @TestMetadata("ScriptAfterExpression.after.kts")
            public void testScriptAfterExpression() throws Exception {
                doNewlineTest("idea/testData/indentationOnNewline/script/ScriptAfterExpression.after.kts");
            }
            
            @TestMetadata("ScriptAfterFun.after.kts")
            public void testScriptAfterFun() throws Exception {
                doNewlineTest("idea/testData/indentationOnNewline/script/ScriptAfterFun.after.kts");
            }
            
            @TestMetadata("ScriptAfterImport.after.kts")
            public void testScriptAfterImport() throws Exception {
                doNewlineTest("idea/testData/indentationOnNewline/script/ScriptAfterImport.after.kts");
            }
            
            @TestMetadata("ScriptInsideFun.after.kts")
            public void testScriptInsideFun() throws Exception {
                doNewlineTest("idea/testData/indentationOnNewline/script/ScriptInsideFun.after.kts");
            }
            
        }
        
        public static Test innerSuite() {
            TestSuite suite = new TestSuite("DirectSettings");
            suite.addTestSuite(DirectSettings.class);
            suite.addTestSuite(Script.class);
            return suite;
        }
    }
    
    @TestMetadata("idea/testData/indentationOnNewline")
    @InnerTestClasses({})
    public static class InvertedSettings extends AbstractJetTypingIndentationTestBase {
        public void testAllFilesPresentInInvertedSettings() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage",
                                                         new File("idea/testData/indentationOnNewline"),
                                                         Pattern.compile("^([^\\.]+)\\.after\\.inv\\.kt.*$"), true);
        }
        
        @TestMetadata("InBinaryExpressionInMiddle.after.inv.kt")
        public void testInBinaryExpressionInMiddle() throws Exception {
            doNewlineTestWithInvert("idea/testData/indentationOnNewline/InBinaryExpressionInMiddle.after.inv.kt");
        }
        
        @TestMetadata("InBinaryExpressionUnfinished.after.inv.kt")
        public void testInBinaryExpressionUnfinished() throws Exception {
            doNewlineTestWithInvert("idea/testData/indentationOnNewline/InBinaryExpressionUnfinished.after.inv.kt");
        }
        
        @TestMetadata("InBinaryExpressionsBeforeCloseParenthesis.after.inv.kt")
        public void testInBinaryExpressionsBeforeCloseParenthesis() throws Exception {
            doNewlineTestWithInvert("idea/testData/indentationOnNewline/InBinaryExpressionsBeforeCloseParenthesis.after.inv.kt");
        }
        
        @TestMetadata("InExpressionsParentheses.after.inv.kt")
        public void testInExpressionsParentheses() throws Exception {
            doNewlineTestWithInvert("idea/testData/indentationOnNewline/InExpressionsParentheses.after.inv.kt");
        }
        
        @TestMetadata("InExpressionsParenthesesBeforeOperand.after.inv.kt")
        public void testInExpressionsParenthesesBeforeOperand() throws Exception {
            doNewlineTestWithInvert("idea/testData/indentationOnNewline/InExpressionsParenthesesBeforeOperand.after.inv.kt");
        }
        
        @TestMetadata("SettingAlignMultilineParametersInCalls.after.inv.kt")
        public void testSettingAlignMultilineParametersInCalls() throws Exception {
            doNewlineTestWithInvert("idea/testData/indentationOnNewline/SettingAlignMultilineParametersInCalls.after.inv.kt");
        }
        
        public static Test innerSuite() {
            TestSuite suite = new TestSuite("InvertedSettings");
            suite.addTestSuite(InvertedSettings.class);
            return suite;
        }
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("JetTypingIndentationTestBaseGenerated");
        suite.addTest(DirectSettings.innerSuite());
        suite.addTest(InvertedSettings.innerSuite());
        return suite;
    }
}