package com.sistema.inmobiliaria.inmo.Steps;

import com.sistema.inmobiliaria.inmo.InmoApplication;
import com.sistema.inmobiliaria.inmo.config.CucumberContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = InmoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class StepsRestBaseIT {

    @LocalServerPort
    public int port;

    public RestTemplate restTemplate;

    @Autowired
    protected CucumberContext cucumberContext;

    public StepsRestBaseIT() {
        restTemplate = new RestTemplate();
    }
}
