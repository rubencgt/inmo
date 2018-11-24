package com.sistema.inmobiliaria.inmo.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware", modifyOnCreate = false)
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        //TODO replace this by real user logged in once spring security is supported by application
        return () -> Optional.of("AppUser");
    }
}
