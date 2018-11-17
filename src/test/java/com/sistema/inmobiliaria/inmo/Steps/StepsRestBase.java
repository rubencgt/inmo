package com.sistema.inmobiliaria.inmo.Steps;

import com.sistema.inmobiliaria.inmo.InmoApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = InmoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class StepsRestBase {

    @LocalServerPort
    public int port;

    public RestTemplate restTemplate;
    
    public StepsRestBase() {
        restTemplate = new RestTemplate();
    }
}
