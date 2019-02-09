package com.sistema.inmobiliaria.inmo.rest;

import com.sistema.inmobiliaria.inmo.core.registration.RegistrationService;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Ruben Guarachi
 */
@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/registration")
    public void registerUserAccount(@RequestBody @Valid UserDto userDto, BindingResult result) {

        if (!result.hasErrors()) {
            registrationService.registerUserAccount(userDto);
        }
    }

    @GetMapping("/user")
    public String regis() {

        return "Logged in";
    }

    @GetMapping("/todos")
    public String regis2() {

        return "Logged in +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
    }
}
