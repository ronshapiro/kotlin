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

package org.jetbrains.jet.codegen;

import com.intellij.testFramework.TestDataPath;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;
import org.jetbrains.jet.JUnit3RunnerWithInners;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/bytecodeText")
@TestDataPath("$PROJECT_ROOT")
@InnerTestClasses({BytecodeTextTestGenerated.BoxingOptimization.class, BytecodeTextTestGenerated.Constants.class, BytecodeTextTestGenerated.DirectInvoke.class, BytecodeTextTestGenerated.Statements.class, BytecodeTextTestGenerated.StoreStackBeforeInline.class, BytecodeTextTestGenerated.When.class, BytecodeTextTestGenerated.WhenEnumOptimization.class, BytecodeTextTestGenerated.WhenStringOptimization.class})
@RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
public class BytecodeTextTestGenerated extends AbstractBytecodeTextTest {
    @TestMetadata("accessorForProtected.kt")
    public void testAccessorForProtected() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/accessorForProtected.kt");
        doTest(fileName);
    }
    
    public void testAllFilesPresentInBytecodeText() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/bytecodeText"), Pattern.compile("^(.+)\\.kt$"), true);
    }
    
    @TestMetadata("annotationRetentionPolicyClass.kt")
    public void testAnnotationRetentionPolicyClass() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/annotationRetentionPolicyClass.kt");
        doTest(fileName);
    }
    
    @TestMetadata("annotationRetentionPolicyRuntime.kt")
    public void testAnnotationRetentionPolicyRuntime() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/annotationRetentionPolicyRuntime.kt");
        doTest(fileName);
    }
    
    @TestMetadata("annotationRetentionPolicySource.kt")
    public void testAnnotationRetentionPolicySource() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/annotationRetentionPolicySource.kt");
        doTest(fileName);
    }
    
    @TestMetadata("bridgeForFakeOverride.kt")
    public void testBridgeForFakeOverride() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/bridgeForFakeOverride.kt");
        doTest(fileName);
    }
    
    @TestMetadata("componentEvaluatesOnlyOnce.kt")
    public void testComponentEvaluatesOnlyOnce() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/componentEvaluatesOnlyOnce.kt");
        doTest(fileName);
    }
    
    @TestMetadata("constClosureOptimization.kt")
    public void testConstClosureOptimization() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/constClosureOptimization.kt");
        doTest(fileName);
    }
    
    @TestMetadata("defaultDelegation.kt")
    public void testDefaultDelegation() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/defaultDelegation.kt");
        doTest(fileName);
    }
    
    @TestMetadata("inlineFromOtherModule.kt")
    public void testInlineFromOtherModule() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/inlineFromOtherModule.kt");
        doTest(fileName);
    }
    
    @TestMetadata("intConstantNotNull.kt")
    public void testIntConstantNotNull() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/intConstantNotNull.kt");
        doTest(fileName);
    }
    
    @TestMetadata("intConstantNullable.kt")
    public void testIntConstantNullable() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/intConstantNullable.kt");
        doTest(fileName);
    }
    
    @TestMetadata("intConstantNullableSafeCall.kt")
    public void testIntConstantNullableSafeCall() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/intConstantNullableSafeCall.kt");
        doTest(fileName);
    }
    
    @TestMetadata("intConstantSafeCall.kt")
    public void testIntConstantSafeCall() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/intConstantSafeCall.kt");
        doTest(fileName);
    }
    
    @TestMetadata("kt2202.kt")
    public void testKt2202() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/kt2202.kt");
        doTest(fileName);
    }
    
    @TestMetadata("kt2887.kt")
    public void testKt2887() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/kt2887.kt");
        doTest(fileName);
    }
    
    @TestMetadata("kt3845.kt")
    public void testKt3845() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/kt3845.kt");
        doTest(fileName);
    }
    
    @TestMetadata("kt5016.kt")
    public void testKt5016() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/kt5016.kt");
        doTest(fileName);
    }
    
    @TestMetadata("kt5016int.kt")
    public void testKt5016int() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/kt5016int.kt");
        doTest(fileName);
    }
    
    @TestMetadata("kt5016intOrNull.kt")
    public void testKt5016intOrNull() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/kt5016intOrNull.kt");
        doTest(fileName);
    }
    
    @TestMetadata("noFlagAnnotations.kt")
    public void testNoFlagAnnotations() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/noFlagAnnotations.kt");
        doTest(fileName);
    }
    
    @TestMetadata("noWrapperForMethodReturningPrimitive.kt")
    public void testNoWrapperForMethodReturningPrimitive() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/noWrapperForMethodReturningPrimitive.kt");
        doTest(fileName);
    }
    
    @TestMetadata("privateDefaultArgs.kt")
    public void testPrivateDefaultArgs() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/privateDefaultArgs.kt");
        doTest(fileName);
    }
    
    @TestMetadata("redundantGotoRemoving.kt")
    public void testRedundantGotoRemoving() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/redundantGotoRemoving.kt");
        doTest(fileName);
    }
    
    @TestMetadata("stringBuilderAppend.kt")
    public void testStringBuilderAppend() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/stringBuilderAppend.kt");
        doTest(fileName);
    }
    
    @TestMetadata("topLevelFunWithDefaultArgs.kt")
    public void testTopLevelFunWithDefaultArgs() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/topLevelFunWithDefaultArgs.kt");
        doTest(fileName);
    }
    
    @TestMetadata("traitImplGeneratedOnce.kt")
    public void testTraitImplGeneratedOnce() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/traitImplGeneratedOnce.kt");
        doTest(fileName);
    }
    
    @TestMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
    public static class BoxingOptimization extends AbstractBytecodeTextTest {
        public void testAllFilesPresentInBoxingOptimization() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/bytecodeText/boxingOptimization"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("casts.kt")
        public void testCasts() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/casts.kt");
            doTest(fileName);
        }
        
        @TestMetadata("checkcastAndInstanceOf.kt")
        public void testCheckcastAndInstanceOf() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/checkcastAndInstanceOf.kt");
            doTest(fileName);
        }
        
        @TestMetadata("fold.kt")
        public void testFold() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/fold.kt");
            doTest(fileName);
        }
        
        @TestMetadata("nullCheck.kt")
        public void testNullCheck() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/nullCheck.kt");
            doTest(fileName);
        }
        
        @TestMetadata("progressions.kt")
        public void testProgressions() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/progressions.kt");
            doTest(fileName);
        }
        
        @TestMetadata("safeCallWithElvis.kt")
        public void testSafeCallWithElvis() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/safeCallWithElvis.kt");
            doTest(fileName);
        }
        
        @TestMetadata("severalInlines.kt")
        public void testSeveralInlines() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/severalInlines.kt");
            doTest(fileName);
        }
        
        @TestMetadata("simple.kt")
        public void testSimple() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/simple.kt");
            doTest(fileName);
        }
        
        @TestMetadata("unsafeRemoving.kt")
        public void testUnsafeRemoving() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/unsafeRemoving.kt");
            doTest(fileName);
        }
        
        @TestMetadata("variableClash.kt")
        public void testVariableClash() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/variableClash.kt");
            doTest(fileName);
        }
        
        @TestMetadata("variables.kt")
        public void testVariables() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/boxingOptimization/variables.kt");
            doTest(fileName);
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/bytecodeText/constants")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
    public static class Constants extends AbstractBytecodeTextTest {
        public void testAllFilesPresentInConstants() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/bytecodeText/constants"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("byte.kt")
        public void testByte() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/constants/byte.kt");
            doTest(fileName);
        }
        
        @TestMetadata("nullableByteAndShort.kt")
        public void testNullableByteAndShort() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/constants/nullableByteAndShort.kt");
            doTest(fileName);
        }
        
        @TestMetadata("short.kt")
        public void testShort() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/constants/short.kt");
            doTest(fileName);
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/bytecodeText/directInvoke")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
    public static class DirectInvoke extends AbstractBytecodeTextTest {
        public void testAllFilesPresentInDirectInvoke() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/bytecodeText/directInvoke"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("callableReference.kt")
        public void testCallableReference() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/directInvoke/callableReference.kt");
            doTest(fileName);
        }
        
        @TestMetadata("inplaceClosure.kt")
        public void testInplaceClosure() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/directInvoke/inplaceClosure.kt");
            doTest(fileName);
        }
        
        @TestMetadata("localFun.kt")
        public void testLocalFun() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/directInvoke/localFun.kt");
            doTest(fileName);
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/bytecodeText/statements")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
    public static class Statements extends AbstractBytecodeTextTest {
        public void testAllFilesPresentInStatements() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/bytecodeText/statements"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("ifSingleBranch.kt")
        public void testIfSingleBranch() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/statements/ifSingleBranch.kt");
            doTest(fileName);
        }
        
        @TestMetadata("ifThenElse.kt")
        public void testIfThenElse() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/statements/ifThenElse.kt");
            doTest(fileName);
        }
        
        @TestMetadata("ifThenElseEmpty.kt")
        public void testIfThenElseEmpty() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/statements/ifThenElseEmpty.kt");
            doTest(fileName);
        }
        
        @TestMetadata("labeled.kt")
        public void testLabeled() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/statements/labeled.kt");
            doTest(fileName);
        }
        
        @TestMetadata("statementsComposition.kt")
        public void testStatementsComposition() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/statements/statementsComposition.kt");
            doTest(fileName);
        }
        
        @TestMetadata("tryCatchFinally.kt")
        public void testTryCatchFinally() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/statements/tryCatchFinally.kt");
            doTest(fileName);
        }
        
        @TestMetadata("when.kt")
        public void testWhen() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/statements/when.kt");
            doTest(fileName);
        }
        
        @TestMetadata("whenSubject.kt")
        public void testWhenSubject() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/statements/whenSubject.kt");
            doTest(fileName);
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/bytecodeText/storeStackBeforeInline")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
    public static class StoreStackBeforeInline extends AbstractBytecodeTextTest {
        public void testAllFilesPresentInStoreStackBeforeInline() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/bytecodeText/storeStackBeforeInline"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("differentTypes.kt")
        public void testDifferentTypes() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/storeStackBeforeInline/differentTypes.kt");
            doTest(fileName);
        }
        
        @TestMetadata("primitiveMerge.kt")
        public void testPrimitiveMerge() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/storeStackBeforeInline/primitiveMerge.kt");
            doTest(fileName);
        }
        
        @TestMetadata("simple.kt")
        public void testSimple() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/storeStackBeforeInline/simple.kt");
            doTest(fileName);
        }
        
        @TestMetadata("unreachableMarker.kt")
        public void testUnreachableMarker() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/storeStackBeforeInline/unreachableMarker.kt");
            doTest(fileName);
        }
        
        @TestMetadata("withLambda.kt")
        public void testWithLambda() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/storeStackBeforeInline/withLambda.kt");
            doTest(fileName);
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/bytecodeText/when")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
    public static class When extends AbstractBytecodeTextTest {
        public void testAllFilesPresentInWhen() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/bytecodeText/when"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("integralWhenWithNoInlinedConstants.kt")
        public void testIntegralWhenWithNoInlinedConstants() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/when/integralWhenWithNoInlinedConstants.kt");
            doTest(fileName);
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
    public static class WhenEnumOptimization extends AbstractBytecodeTextTest {
        public void testAllFilesPresentInWhenEnumOptimization() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/bytecodeText/whenEnumOptimization"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("bigEnum.kt")
        public void testBigEnum() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization/bigEnum.kt");
            doTest(fileName);
        }
        
        @TestMetadata("duplicatingItems.kt")
        public void testDuplicatingItems() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization/duplicatingItems.kt");
            doTest(fileName);
        }
        
        @TestMetadata("expression.kt")
        public void testExpression() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization/expression.kt");
            doTest(fileName);
        }
        
        @TestMetadata("functionLiteralInTopLevel.kt")
        public void testFunctionLiteralInTopLevel() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization/functionLiteralInTopLevel.kt");
            doTest(fileName);
        }
        
        @TestMetadata("manyWhensWithinClass.kt")
        public void testManyWhensWithinClass() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization/manyWhensWithinClass.kt");
            doTest(fileName);
        }
        
        @TestMetadata("nonConstantEnum.kt")
        public void testNonConstantEnum() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization/nonConstantEnum.kt");
            doTest(fileName);
        }
        
        @TestMetadata("nullability.kt")
        public void testNullability() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization/nullability.kt");
            doTest(fileName);
        }
        
        @TestMetadata("subjectAny.kt")
        public void testSubjectAny() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization/subjectAny.kt");
            doTest(fileName);
        }
        
        @TestMetadata("withoutElse.kt")
        public void testWithoutElse() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenEnumOptimization/withoutElse.kt");
            doTest(fileName);
        }
        
    }
    
    @TestMetadata("compiler/testData/codegen/bytecodeText/whenStringOptimization")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
    public static class WhenStringOptimization extends AbstractBytecodeTextTest {
        public void testAllFilesPresentInWhenStringOptimization() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/codegen/bytecodeText/whenStringOptimization"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("denseHashCode.kt")
        public void testDenseHashCode() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenStringOptimization/denseHashCode.kt");
            doTest(fileName);
        }
        
        @TestMetadata("duplicatingItems.kt")
        public void testDuplicatingItems() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenStringOptimization/duplicatingItems.kt");
            doTest(fileName);
        }
        
        @TestMetadata("duplicatingItemsSameHashCode.kt")
        public void testDuplicatingItemsSameHashCode() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenStringOptimization/duplicatingItemsSameHashCode.kt");
            doTest(fileName);
        }
        
        @TestMetadata("expression.kt")
        public void testExpression() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenStringOptimization/expression.kt");
            doTest(fileName);
        }
        
        @TestMetadata("nonInlinedConst.kt")
        public void testNonInlinedConst() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenStringOptimization/nonInlinedConst.kt");
            doTest(fileName);
        }
        
        @TestMetadata("nullability.kt")
        public void testNullability() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenStringOptimization/nullability.kt");
            doTest(fileName);
        }
        
        @TestMetadata("sameHashCode.kt")
        public void testSameHashCode() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenStringOptimization/sameHashCode.kt");
            doTest(fileName);
        }
        
        @TestMetadata("statement.kt")
        public void testStatement() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/codegen/bytecodeText/whenStringOptimization/statement.kt");
            doTest(fileName);
        }
        
    }
    
}
