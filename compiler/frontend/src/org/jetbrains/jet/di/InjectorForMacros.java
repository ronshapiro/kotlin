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

package org.jetbrains.jet.di;

import com.intellij.openapi.project.Project;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptor;
import org.jetbrains.jet.lang.PlatformToKotlinClassMap;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingServices;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingComponents;
import org.jetbrains.jet.lang.resolve.calls.CallResolver;
import org.jetbrains.jet.context.GlobalContext;
import org.jetbrains.jet.storage.StorageManager;
import org.jetbrains.jet.lang.resolve.AdditionalCheckerProvider;
import org.jetbrains.jet.lang.resolve.AnnotationResolver;
import org.jetbrains.jet.lang.resolve.TypeResolver;
import org.jetbrains.jet.lang.resolve.TypeResolver.FlexibleTypeCapabilitiesProvider;
import org.jetbrains.jet.lang.resolve.QualifiedExpressionResolver;
import org.jetbrains.jet.lang.resolve.calls.CallExpressionResolver;
import org.jetbrains.jet.lang.resolve.DescriptorResolver;
import org.jetbrains.jet.lang.resolve.DelegatedPropertyResolver;
import org.jetbrains.jet.lang.resolve.calls.CallResolverExtensionProvider;
import org.jetbrains.jet.lang.types.expressions.ControlStructureTypingUtils;
import org.jetbrains.jet.lang.types.expressions.ExpressionTypingUtils;
import org.jetbrains.jet.lang.types.expressions.ForLoopConventionsChecker;
import org.jetbrains.jet.lang.reflect.ReflectionTypes;
import org.jetbrains.jet.lang.resolve.calls.ArgumentTypeResolver;
import org.jetbrains.jet.lang.resolve.calls.CallCompleter;
import org.jetbrains.jet.lang.resolve.calls.CandidateResolver;
import org.jetbrains.annotations.NotNull;
import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.jet.generators.injectors.InjectorsPackage. DO NOT EDIT! */
@SuppressWarnings("all")
public class InjectorForMacros {

    private final Project project;
    private final ModuleDescriptor moduleDescriptor;
    private final PlatformToKotlinClassMap platformToKotlinClassMap;
    private final ExpressionTypingServices expressionTypingServices;
    private final ExpressionTypingComponents expressionTypingComponents;
    private final CallResolver callResolver;
    private final GlobalContext globalContext;
    private final StorageManager storageManager;
    private final AdditionalCheckerProvider additionalCheckerProvider;
    private final AnnotationResolver annotationResolver;
    private final TypeResolver typeResolver;
    private final FlexibleTypeCapabilitiesProvider flexibleTypeCapabilitiesProvider;
    private final QualifiedExpressionResolver qualifiedExpressionResolver;
    private final CallExpressionResolver callExpressionResolver;
    private final DescriptorResolver descriptorResolver;
    private final DelegatedPropertyResolver delegatedPropertyResolver;
    private final CallResolverExtensionProvider callResolverExtensionProvider;
    private final ControlStructureTypingUtils controlStructureTypingUtils;
    private final ExpressionTypingUtils expressionTypingUtils;
    private final ForLoopConventionsChecker forLoopConventionsChecker;
    private final ReflectionTypes reflectionTypes;
    private final ArgumentTypeResolver argumentTypeResolver;
    private final CallCompleter callCompleter;
    private final CandidateResolver candidateResolver;

    public InjectorForMacros(
        @NotNull Project project,
        @NotNull ModuleDescriptor moduleDescriptor
    ) {
        this.project = project;
        this.moduleDescriptor = moduleDescriptor;
        this.platformToKotlinClassMap = moduleDescriptor.getPlatformToKotlinClassMap();
        this.expressionTypingComponents = new ExpressionTypingComponents();
        this.expressionTypingServices = new ExpressionTypingServices(getExpressionTypingComponents());
        this.callResolver = new CallResolver();
        this.globalContext = org.jetbrains.jet.context.ContextPackage.GlobalContext();
        this.storageManager = globalContext.getStorageManager();
        this.additionalCheckerProvider = org.jetbrains.jet.lang.resolve.AdditionalCheckerProvider.Empty.INSTANCE$;
        this.annotationResolver = new AnnotationResolver();
        this.typeResolver = new TypeResolver();
        this.flexibleTypeCapabilitiesProvider = new FlexibleTypeCapabilitiesProvider();
        this.qualifiedExpressionResolver = new QualifiedExpressionResolver();
        this.callExpressionResolver = new CallExpressionResolver();
        this.descriptorResolver = new DescriptorResolver();
        this.delegatedPropertyResolver = new DelegatedPropertyResolver();
        this.callResolverExtensionProvider = new CallResolverExtensionProvider();
        this.controlStructureTypingUtils = new ControlStructureTypingUtils(getExpressionTypingServices());
        this.expressionTypingUtils = new ExpressionTypingUtils(getExpressionTypingServices(), getCallResolver());
        this.forLoopConventionsChecker = new ForLoopConventionsChecker();
        this.reflectionTypes = new ReflectionTypes(moduleDescriptor);
        this.argumentTypeResolver = new ArgumentTypeResolver();
        this.candidateResolver = new CandidateResolver();
        this.callCompleter = new CallCompleter(argumentTypeResolver, candidateResolver);

        this.expressionTypingServices.setAnnotationResolver(annotationResolver);
        this.expressionTypingServices.setCallExpressionResolver(callExpressionResolver);
        this.expressionTypingServices.setCallResolver(callResolver);
        this.expressionTypingServices.setDescriptorResolver(descriptorResolver);
        this.expressionTypingServices.setExtensionProvider(callResolverExtensionProvider);
        this.expressionTypingServices.setProject(project);
        this.expressionTypingServices.setTypeResolver(typeResolver);

        this.expressionTypingComponents.setAdditionalCheckerProvider(additionalCheckerProvider);
        this.expressionTypingComponents.setCallResolver(callResolver);
        this.expressionTypingComponents.setControlStructureTypingUtils(controlStructureTypingUtils);
        this.expressionTypingComponents.setExpressionTypingServices(expressionTypingServices);
        this.expressionTypingComponents.setExpressionTypingUtils(expressionTypingUtils);
        this.expressionTypingComponents.setForLoopConventionsChecker(forLoopConventionsChecker);
        this.expressionTypingComponents.setGlobalContext(globalContext);
        this.expressionTypingComponents.setPlatformToKotlinClassMap(platformToKotlinClassMap);
        this.expressionTypingComponents.setReflectionTypes(reflectionTypes);

        this.callResolver.setArgumentTypeResolver(argumentTypeResolver);
        this.callResolver.setCallCompleter(callCompleter);
        this.callResolver.setCandidateResolver(candidateResolver);
        this.callResolver.setExpressionTypingServices(expressionTypingServices);
        this.callResolver.setTypeResolver(typeResolver);

        annotationResolver.setCallResolver(callResolver);
        annotationResolver.setStorageManager(storageManager);
        annotationResolver.setTypeResolver(typeResolver);

        typeResolver.setAnnotationResolver(annotationResolver);
        typeResolver.setFlexibleTypeCapabilitiesProvider(flexibleTypeCapabilitiesProvider);
        typeResolver.setModuleDescriptor(moduleDescriptor);
        typeResolver.setQualifiedExpressionResolver(qualifiedExpressionResolver);

        callExpressionResolver.setExpressionTypingServices(expressionTypingServices);

        descriptorResolver.setAnnotationResolver(annotationResolver);
        descriptorResolver.setDelegatedPropertyResolver(delegatedPropertyResolver);
        descriptorResolver.setExpressionTypingServices(expressionTypingServices);
        descriptorResolver.setStorageManager(storageManager);
        descriptorResolver.setTypeResolver(typeResolver);

        delegatedPropertyResolver.setCallResolver(callResolver);
        delegatedPropertyResolver.setExpressionTypingServices(expressionTypingServices);

        forLoopConventionsChecker.setExpressionTypingServices(expressionTypingServices);
        forLoopConventionsChecker.setExpressionTypingUtils(expressionTypingUtils);
        forLoopConventionsChecker.setProject(project);

        argumentTypeResolver.setExpressionTypingServices(expressionTypingServices);
        argumentTypeResolver.setTypeResolver(typeResolver);

        candidateResolver.setArgumentTypeResolver(argumentTypeResolver);

    }

    @PreDestroy
    public void destroy() {
    }

    public ExpressionTypingServices getExpressionTypingServices() {
        return this.expressionTypingServices;
    }

    public ExpressionTypingComponents getExpressionTypingComponents() {
        return this.expressionTypingComponents;
    }

    public CallResolver getCallResolver() {
        return this.callResolver;
    }

}
