/*
 * Copyright 2010-2013 JetBrains s.r.o.
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

import org.jetbrains.jet.lang.resolve.java.JavaSemanticServices;
import org.jetbrains.jet.lang.resolve.java.JavaDescriptorResolver;
import org.jetbrains.jet.lang.resolve.BindingTrace;
import org.jetbrains.jet.lang.resolve.java.JavaBridgeConfiguration;
import org.jetbrains.jet.lang.resolve.java.PsiClassFinderImpl;
import org.jetbrains.jet.lang.descriptors.ModuleDescriptorImpl;
import com.intellij.openapi.project.Project;
import org.jetbrains.jet.lang.resolve.java.provider.PsiDeclarationProviderFactory;
import org.jetbrains.jet.lang.resolve.java.JavaTypeTransformer;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaClassResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaAnnotationResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaCompileTimeConstResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaFunctionResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaValueParameterResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaSignatureResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.DeserializedDescriptorResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.AnnotationDescriptorDeserializer;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaNamespaceResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaSupertypeResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaConstructorResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaInnerClassResolver;
import org.jetbrains.jet.lang.resolve.java.resolver.JavaPropertyResolver;
import org.jetbrains.annotations.NotNull;
import javax.annotation.PreDestroy;

/* This file is generated by org.jetbrains.jet.generators.injectors.GenerateInjectors. DO NOT EDIT! */
public class InjectorForJavaSemanticServices {
    
    private JavaSemanticServices javaSemanticServices;
    private JavaDescriptorResolver javaDescriptorResolver;
    private BindingTrace bindingTrace;
    private JavaBridgeConfiguration javaBridgeConfiguration;
    private PsiClassFinderImpl psiClassFinder;
    private ModuleDescriptorImpl moduleDescriptor;
    private final Project project;
    private PsiDeclarationProviderFactory psiDeclarationProviderFactory;
    private JavaTypeTransformer javaTypeTransformer;
    private JavaClassResolver javaClassResolver;
    private JavaAnnotationResolver javaAnnotationResolver;
    private JavaCompileTimeConstResolver javaCompileTimeConstResolver;
    private JavaFunctionResolver javaFunctionResolver;
    private JavaValueParameterResolver javaValueParameterResolver;
    private JavaSignatureResolver javaSignatureResolver;
    private DeserializedDescriptorResolver deserializedDescriptorResolver;
    private AnnotationDescriptorDeserializer annotationDescriptorDeserializer;
    private JavaNamespaceResolver javaNamespaceResolver;
    private JavaSupertypeResolver javaSupertypeResolver;
    private JavaConstructorResolver javaConstructorResolver;
    private JavaInnerClassResolver javaInnerClassResolver;
    private JavaPropertyResolver javaPropertyResolver;
    
    public InjectorForJavaSemanticServices(
        @NotNull Project project
    ) {
        this.javaSemanticServices = new JavaSemanticServices();
        this.javaDescriptorResolver = new JavaDescriptorResolver();
        this.bindingTrace = new org.jetbrains.jet.lang.resolve.BindingTraceContext();
        this.javaBridgeConfiguration = new JavaBridgeConfiguration();
        this.psiClassFinder = new PsiClassFinderImpl();
        this.moduleDescriptor = new org.jetbrains.jet.lang.descriptors.ModuleDescriptorImpl(org.jetbrains.jet.lang.resolve.name.Name.special("<dummy>"), org.jetbrains.jet.lang.resolve.java.JavaBridgeConfiguration.ALL_JAVA_IMPORTS, org.jetbrains.jet.lang.resolve.java.JavaToKotlinClassMap.getInstance());
        this.project = project;
        this.psiDeclarationProviderFactory = new PsiDeclarationProviderFactory(getPsiClassFinder());
        this.javaTypeTransformer = new JavaTypeTransformer();
        this.javaClassResolver = new JavaClassResolver();
        this.javaAnnotationResolver = new JavaAnnotationResolver();
        this.javaCompileTimeConstResolver = new JavaCompileTimeConstResolver();
        this.javaFunctionResolver = new JavaFunctionResolver();
        this.javaValueParameterResolver = new JavaValueParameterResolver();
        this.javaSignatureResolver = new JavaSignatureResolver();
        this.deserializedDescriptorResolver = new DeserializedDescriptorResolver();
        this.annotationDescriptorDeserializer = new AnnotationDescriptorDeserializer();
        this.javaNamespaceResolver = new JavaNamespaceResolver();
        this.javaSupertypeResolver = new JavaSupertypeResolver();
        this.javaConstructorResolver = new JavaConstructorResolver();
        this.javaInnerClassResolver = new JavaInnerClassResolver();
        this.javaPropertyResolver = new JavaPropertyResolver();

        this.javaSemanticServices.setDescriptorResolver(javaDescriptorResolver);
        this.javaSemanticServices.setPsiClassFinder(psiClassFinder);
        this.javaSemanticServices.setPsiDeclarationProviderFactory(psiDeclarationProviderFactory);
        this.javaSemanticServices.setTrace(bindingTrace);
        this.javaSemanticServices.setTypeTransformer(javaTypeTransformer);

        this.javaDescriptorResolver.setClassResolver(javaClassResolver);
        this.javaDescriptorResolver.setConstructorResolver(javaConstructorResolver);
        this.javaDescriptorResolver.setFunctionResolver(javaFunctionResolver);
        this.javaDescriptorResolver.setInnerClassResolver(javaInnerClassResolver);
        this.javaDescriptorResolver.setNamespaceResolver(javaNamespaceResolver);
        this.javaDescriptorResolver.setPropertiesResolver(javaPropertyResolver);

        javaBridgeConfiguration.setJavaSemanticServices(javaSemanticServices);

        this.psiClassFinder.setProject(project);

        moduleDescriptor.setModuleConfiguration(javaBridgeConfiguration);

        javaTypeTransformer.setResolver(javaDescriptorResolver);

        javaClassResolver.setAnnotationResolver(javaAnnotationResolver);
        javaClassResolver.setFunctionResolver(javaFunctionResolver);
        javaClassResolver.setKotlinDescriptorResolver(deserializedDescriptorResolver);
        javaClassResolver.setNamespaceResolver(javaNamespaceResolver);
        javaClassResolver.setPsiClassFinder(psiClassFinder);
        javaClassResolver.setSemanticServices(javaSemanticServices);
        javaClassResolver.setSignatureResolver(javaSignatureResolver);
        javaClassResolver.setSupertypesResolver(javaSupertypeResolver);
        javaClassResolver.setTrace(bindingTrace);

        javaAnnotationResolver.setClassResolver(javaClassResolver);
        javaAnnotationResolver.setCompileTimeConstResolver(javaCompileTimeConstResolver);

        javaCompileTimeConstResolver.setAnnotationResolver(javaAnnotationResolver);
        javaCompileTimeConstResolver.setClassResolver(javaClassResolver);

        javaFunctionResolver.setAnnotationResolver(javaAnnotationResolver);
        javaFunctionResolver.setParameterResolver(javaValueParameterResolver);
        javaFunctionResolver.setSignatureResolver(javaSignatureResolver);
        javaFunctionResolver.setTrace(bindingTrace);
        javaFunctionResolver.setTypeTransformer(javaTypeTransformer);

        javaValueParameterResolver.setTypeTransformer(javaTypeTransformer);

        javaSignatureResolver.setJavaSemanticServices(javaSemanticServices);

        deserializedDescriptorResolver.setAnnotationDeserializer(annotationDescriptorDeserializer);
        deserializedDescriptorResolver.setJavaClassResolver(javaClassResolver);
        deserializedDescriptorResolver.setJavaNamespaceResolver(javaNamespaceResolver);

        annotationDescriptorDeserializer.setJavaClassResolver(javaClassResolver);
        annotationDescriptorDeserializer.setPsiClassFinder(psiClassFinder);

        javaNamespaceResolver.setDeserializedDescriptorResolver(deserializedDescriptorResolver);
        javaNamespaceResolver.setJavaSemanticServices(javaSemanticServices);
        javaNamespaceResolver.setPsiClassFinder(psiClassFinder);
        javaNamespaceResolver.setTrace(bindingTrace);

        javaSupertypeResolver.setClassResolver(javaClassResolver);
        javaSupertypeResolver.setTrace(bindingTrace);
        javaSupertypeResolver.setTypeTransformer(javaTypeTransformer);

        javaConstructorResolver.setTrace(bindingTrace);
        javaConstructorResolver.setTypeTransformer(javaTypeTransformer);
        javaConstructorResolver.setValueParameterResolver(javaValueParameterResolver);

        javaInnerClassResolver.setClassResolver(javaClassResolver);

        javaPropertyResolver.setAnnotationResolver(javaAnnotationResolver);
        javaPropertyResolver.setSemanticServices(javaSemanticServices);
        javaPropertyResolver.setTrace(bindingTrace);

        psiClassFinder.initialize();

    }
    
    @PreDestroy
    public void destroy() {
    }
    
    public JavaSemanticServices getJavaSemanticServices() {
        return this.javaSemanticServices;
    }
    
    public JavaDescriptorResolver getJavaDescriptorResolver() {
        return this.javaDescriptorResolver;
    }
    
    public BindingTrace getBindingTrace() {
        return this.bindingTrace;
    }
    
    public PsiClassFinderImpl getPsiClassFinder() {
        return this.psiClassFinder;
    }
    
    public Project getProject() {
        return this.project;
    }
    
}
