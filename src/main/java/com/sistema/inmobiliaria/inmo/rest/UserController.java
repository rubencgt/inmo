package com.sistema.inmobiliaria.inmo.rest;

import com.sistema.inmobiliaria.inmo.core.registration.RegistrationService;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Ruben Guarachi
 */
@RestController
public class UserController {

    public static final String BASE_URL = "/users";

    @Autowired
    private RegistrationService registrationService;

    @PostMapping(BASE_URL)
    public ResponseEntity registerUserAccount(@RequestBody @Valid UserDto userDto, BindingResult result) throws URISyntaxException {
        if (!result.hasErrors()) {
            registrationService.registerUserAccount(userDto);
        }
        return ResponseEntity.created(new URI(BASE_URL)).build();
    }

    @GetMapping("/user")
    public String regis() {
        //todo add User specific logic e.g. add new add
        return "Logged in from /user";
    }
}
