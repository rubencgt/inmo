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
public class UserController {

    public static final String BASE_URL = "/users";

    @Autowired
    private RegistrationService registrationService;

    @PostMapping(BASE_URL)
    public void registerUserAccount(@RequestBody @Valid UserDto userDto, BindingResult result) {

        if (!result.hasErrors()) {
            registrationService.registerUserAccount(userDto);
        }
    }

    @GetMapping("/user")
    public String regis() {
        //todo add User specific logic e.g. add new add
        return "Logged in from /user";
    }
}
