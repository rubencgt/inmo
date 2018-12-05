package com.sistema.inmobiliaria.inmo.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


@Configuration
public class TestConfig {

    @Bean
    public static PropertyPlaceholderConfigurer properties() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        Resource resources = new ClassPathResource("application.properties");
        ppc.setLocation(resources);
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }

}
