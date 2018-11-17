package com.sistema.inmobiliaria.inmo.rest;

import com.sistema.inmobiliaria.inmo.domain.Test;
import com.sistema.inmobiliaria.inmo.domain.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/version")
    public String getVersion() {
//        Test test = new Test();
//        test.setName("Some name");
//        testRepository.save(test);

//        System.out.println(testRepository.getOne(0L));
        return "1.0";

    }
}