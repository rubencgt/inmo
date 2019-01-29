package com.sistema.inmobiliaria.inmo.config;

import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CucumberContext {

    private long customerId;

    private long propertyId;

    private String fileName;

    private UserDto testUser;
}
