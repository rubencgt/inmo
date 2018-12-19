package com.sistema.inmobiliaria.inmo.rest;

import com.sistema.inmobiliaria.inmo.domain.user.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/version")
    public String getVersion() {
        return "1.0";
    }
}