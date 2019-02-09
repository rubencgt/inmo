package com.sistema.inmobiliaria.inmo.core;

import com.sistema.inmobiliaria.inmo.domain.user.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware", modifyOnCreate = false)
public class JpaConfig {

    private static final String SYSTEM = "SYSTEM";

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> {
            boolean isUser = SecurityContextHolder.getContext().getAuthentication()
                    .getAuthorities().stream()
                    .anyMatch(authority -> authority.getAuthority().equals(UserDetailsServiceImpl.ROLE));

            if (isUser) {
                User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return Optional.of(user.getUsername());
            }
            return Optional.of(SYSTEM);
        };
    }
}
