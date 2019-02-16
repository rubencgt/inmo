package com.sistema.inmobiliaria.inmo.steps;

import com.sistema.inmobiliaria.inmo.InmoApplication;
import com.sistema.inmobiliaria.inmo.config.CucumberContext;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootTest(classes = InmoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class StepsRestBaseIT {

    @LocalServerPort
    public int port;

    public String inmoUrlBase;

    public RestTemplate restTemplate;

    public OAuth2RestTemplate auth2RestTemplate;

    @Autowired
    protected CucumberContext cucumberContext;

    @PostConstruct
    public void init() {
        this.inmoUrlBase = "http://localhost:" + port;
        restTemplate = new RestTemplateBuilder().build();
        auth2RestTemplate = new OAuth2RestTemplate(createUserDetails());
    }

    private ResourceOwnerPasswordResourceDetails createUserDetails() {
        ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
        details.setClientId("inmo-client");
        details.setClientSecret("inmo-secret");
        details.setPassword("password");
        details.setUsername("some@email.com");
        details.setAccessTokenUri(inmoUrlBase + "/oauth/token");
        return details;
    }

    protected UserDto createUserDto() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("Some name");
        userDto.setLastName("Some last name");
        userDto.setEmail("some@email.com");
        userDto.setPassword("password");
        userDto.setMatchingPassword("password");
        return userDto;
    }

}
