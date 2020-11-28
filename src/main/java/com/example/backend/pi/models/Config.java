package com.example.backend.pi.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.geo.GeoModule;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.mediatype.MessageResolver;
import org.springframework.hateoas.mediatype.hal.CurieProvider;
import org.springframework.hateoas.mediatype.hal.HalConfiguration;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.hateoas.server.mvc.RepresentationModelProcessorInvoker;

@Configuration
public class Config extends RepositoryRestMvcConfiguration {

    public Config(ApplicationContext context, ObjectFactory<ConversionService> conversionService,
            Optional<LinkRelationProvider> relProvider, Optional<CurieProvider> curieProvider,
            Optional<HalConfiguration> halConfiguration, ObjectProvider<ObjectMapper> objectMapper,
            ObjectProvider<RepresentationModelProcessorInvoker> invoker, MessageResolver resolver,
            GeoModule geoModule) {
        super(context, conversionService, relProvider, curieProvider, halConfiguration, objectMapper, invoker, resolver,
                geoModule);
    }

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer(EntityManagerFactory entityManagerFactory) {
        List<Class<?>> entityClasses = getAllManagedEntityTypes(entityManagerFactory);

        return new RepositoryRestConfigurer() {

            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
                for (Class<?> entityClass : entityClasses) {
                    config.exposeIdsFor(entityClass);
                }
            }
        };    
    }


private List<Class<?>> getAllManagedEntityTypes(EntityManagerFactory entityManagerFactory) {
    List<Class<?>> entityClasses = new ArrayList<>();
    Metamodel metamodel = entityManagerFactory.getMetamodel();
    for (ManagedType<?> managedType : metamodel.getManagedTypes()) {
        Class<?> javaType = managedType.getJavaType();
        if (javaType.isAnnotationPresent(Entity.class)) {
            entityClasses.add(managedType.getJavaType());
        }
    }
    return entityClasses;
}
}