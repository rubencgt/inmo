package com.sistema.inmobiliaria.inmo;

import com.sistema.inmobiliaria.inmo.core.registration.RegistrationService;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InmoApplication implements ApplicationRunner {

    @Autowired
    private RegistrationService registrationService;

    public static void main(String[] args) {
        SpringApplication.run(InmoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        UserDto user = new UserDto();
        user.setFirstName("Juan");
        user.setLastName("Conde");
        user.setPassword("password");
        user.setMatchingPassword("password");
        user.setEmail("email@email.com");
        registrationService.registerUserAccount(user);
    }
}
