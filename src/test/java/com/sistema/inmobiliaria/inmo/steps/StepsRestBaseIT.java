package com.sistema.inmobiliaria.inmo.steps;

import com.sistema.inmobiliaria.inmo.InmoApplication;
import com.sistema.inmobiliaria.inmo.config.CucumberContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootTest(classes = InmoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class StepsRestBaseIT {

    @LocalServerPort
    public int port;

    public String restBase;

    public RestTemplate restTemplate;

    @Autowired
    protected CucumberContext cucumberContext;

    @PostConstruct
    public void init() {
        this.restBase = "http://localhost:" + port;
        restTemplate = new RestTemplateBuilder().build();
    }

}
