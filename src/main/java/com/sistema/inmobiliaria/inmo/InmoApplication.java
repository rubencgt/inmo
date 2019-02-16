package com.sistema.inmobiliaria.inmo;

import com.sistema.inmobiliaria.inmo.core.registration.RegistrationService;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InmoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InmoApplication.class, args);
    }
}
