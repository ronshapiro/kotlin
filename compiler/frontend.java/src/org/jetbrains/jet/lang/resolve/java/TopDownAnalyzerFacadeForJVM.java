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

package org.jetbrains.jet.lang.resolve.java;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jet.analyzer.AnalyzeExhaust;
import org.jetbrains.jet.context.ContextPackage;
import org.jetbrains.jet.context.GlobalContext;
import org.jetbrains.jet.context.GlobalContextImpl;
import org.jetbrains.jet.di.InjectorForTopDownAnalyzerForJvm;
import org.jetbrains.jet.lang.descriptors.PackageFragmentProvider;
import org.jetbrains.jet.lang.descriptors.impl.ModuleDescriptorImpl;
import org.jetbrains.jet.lang.psi.JetFile;
import org.jetbrains.jet.lang.resolve.*;
import org.jetbrains.jet.lang.resolve.java.mapping.JavaToKotlinClassMap;
import org.jetbrains.jet.lang.resolve.kotlin.incremental.IncrementalPackageFragmentProvider;
import org.jetbrains.jet.lang.resolve.kotlin.incremental.cache.IncrementalCache;
import org.jetbrains.jet.lang.resolve.kotlin.incremental.cache.IncrementalCacheProvider;
import org.jetbrains.jet.lang.resolve.lazy.declarations.FileBasedDeclarationProviderFactory;
import org.jetbrains.jet.lang.resolve.name.Name;
import org.jetbrains.jet.lang.types.lang.KotlinBuiltIns;
import org.jetbrains.jet.storage.LockBasedStorageManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public enum TopDownAnalyzerFacadeForJVM {

    INSTANCE;

    public static final List<ImportPath> DEFAULT_IMPORTS = ImmutableList.of(
            new ImportPath("java.lang.*"),
            new ImportPath("kotlin.*"),
            new ImportPath("kotlin.jvm.*"),
            new ImportPath("kotlin.io.*")
    );

    private TopDownAnalyzerFacadeForJVM() {
    }

    @NotNull
    public static AnalyzeExhaust analyzeFilesWithJavaIntegration(
            @NotNull Project project,
            @NotNull Collection<JetFile> files,
            @NotNull BindingTrace trace,
            @NotNull TopDownAnalysisParameters topDownAnalysisParameters,
            @NotNull ModuleDescriptorImpl module
    ) {
        GlobalContext globalContext = new GlobalContextImpl(
                (LockBasedStorageManager) topDownAnalysisParameters.getStorageManager(),
                topDownAnalysisParameters.getExceptionTracker());

        return analyzeFilesWithJavaIntegration(project, files, trace, topDownAnalysisParameters, module, globalContext, null, null);
    }

    @NotNull
    public static AnalyzeExhaust analyzeFilesWithJavaIntegration(
            @NotNull Project project,
            @NotNull Collection<JetFile> files,
            @NotNull BindingTrace trace,
            @NotNull Predicate<PsiFile> filesToAnalyzeCompletely,
            @NotNull ModuleDescriptorImpl module,
            @Nullable List<String> moduleIds,
            @Nullable IncrementalCacheProvider incrementalCacheProvider
    ) {
        GlobalContext globalContext = ContextPackage.GlobalContext();
        TopDownAnalysisParameters topDownAnalysisParameters = TopDownAnalysisParameters.create(
                globalContext.getStorageManager(),
                globalContext.getExceptionTracker(),
                filesToAnalyzeCompletely,
                false,
                false
        );

        return analyzeFilesWithJavaIntegration(
                project, files, trace, topDownAnalysisParameters, module,
                globalContext, moduleIds, incrementalCacheProvider);
    }

    @NotNull
    private static AnalyzeExhaust analyzeFilesWithJavaIntegration(
            Project project,
            Collection<JetFile> files,
            BindingTrace trace,
            TopDownAnalysisParameters topDownAnalysisParameters,
            ModuleDescriptorImpl module,
            GlobalContext globalContext,
            @Nullable List<String> moduleIds,
            @Nullable IncrementalCacheProvider incrementalCacheProvider
    ) {
        FileBasedDeclarationProviderFactory providerFactory =
                new FileBasedDeclarationProviderFactory(topDownAnalysisParameters.getStorageManager(), files);

        InjectorForTopDownAnalyzerForJvm injector = new InjectorForTopDownAnalyzerForJvm(
                project,
                globalContext,
                trace,
                module,
                GlobalSearchScope.allScope(project),
                providerFactory
        );

        try {
            List<PackageFragmentProvider> additionalProviders = new ArrayList<PackageFragmentProvider>();

            if (moduleIds != null && incrementalCacheProvider != null) {
                for (String moduleId : moduleIds) {
                    IncrementalCache incrementalCache = incrementalCacheProvider.getIncrementalCache(moduleId);

                    additionalProviders.add(
                            new IncrementalPackageFragmentProvider(
                                    files, module, topDownAnalysisParameters.getStorageManager(), injector.getDeserializationGlobalContextForJava(),
                                    incrementalCache, moduleId, injector.getJavaDescriptorResolver()
                            )
                    );
                }
            }
            additionalProviders.add(injector.getJavaDescriptorResolver().getPackageFragmentProvider());

            injector.getLazyTopDownAnalyzer().analyzeFiles(topDownAnalysisParameters, files, additionalProviders);
            return AnalyzeExhaust.success(trace.getBindingContext(), module);
        }
        finally {
            injector.destroy();
        }
    }

    @NotNull
    public static ModuleDescriptorImpl createJavaModule(@NotNull String name) {
        return new ModuleDescriptorImpl(Name.special(name),
                                        DEFAULT_IMPORTS,
                                        JavaToKotlinClassMap.getInstance());
    }

    @NotNull
    public static ModuleDescriptorImpl createAnalyzeModule() {
        ModuleDescriptorImpl module = createJavaModule("<shared-module>");
        module.addDependencyOnModule(module);
        module.addDependencyOnModule(KotlinBuiltIns.getInstance().getBuiltInsModule());
        module.seal();
        return module;
    }
}
