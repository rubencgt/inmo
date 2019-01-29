package com.sistema.inmobiliaria.inmo.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CucumberContext {

    private long customerId;

    private long propertyId;

    private String fileName;
}
