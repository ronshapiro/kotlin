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

package org.jetbrains.jet.j2k.test;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("j2k/tests/testData/multiFile")
@TestDataPath("$PROJECT_ROOT")
@InnerTestClasses({})
@RunWith(org.jetbrains.jet.JUnit3RunnerWithInners.class)
public class JavaToKotlinConverterMultiFileTestGenerated extends AbstractJavaToKotlinConverterMultiFileTest {
    public void testAllFilesPresentInMultiFile() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("j2k/tests/testData/multiFile"), Pattern.compile("^([^\\.]+)$"), true);
    }
    
    @TestMetadata("GetterAndSetterUsages")
    public void testGetterAndSetterUsages() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("j2k/tests/testData/multiFile/GetterAndSetterUsages/");
        doTest(fileName);
    }
    
}
