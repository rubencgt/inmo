package com.sistema.inmobiliaria.inmo.cucumbersteps;

import com.sistema.inmobiliaria.inmo.InmoApplication;
import com.sistema.inmobiliaria.inmo.config.CucumberContext;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

@SpringBootTest(classes = InmoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class StepsRestBaseIT {

    @LocalServerPort
    public int port;

    public String inmoUrlBase;

    public RestTemplate restTemplate;

    @Autowired
    protected CucumberContext cucumberContext;

    @PostConstruct
    public void init() {
        this.inmoUrlBase = "http://localhost:" + port;
        restTemplate = new RestTemplateBuilder().build();
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


    private String getTokenUrl(String email, String password) {
        return UriComponentsBuilder.fromUriString(inmoUrlBase + "/oauth/token")
                .queryParam("grant_type", "password")
                .queryParam("username", email)
                .queryParam("password", password)
                .buildAndExpand().toString();
    }

    protected HttpHeaders getHeadersWithToken(String email, String password) throws JSONException {
        HttpEntity<?> request = authorizeRequest();
        String url = getTokenUrl(email, password);
        ResponseEntity<String> result = restTemplate.postForEntity(url, request, String.class);
        JSONObject jsonObject = new JSONObject(result.getBody());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + jsonObject.getString("access_token"));
        return headers;
    }

    private HttpEntity<?> authorizeRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String base64Creds = new String(Base64.encodeBase64("inmo-client:inmo-secret".getBytes()));
        headers.add("Authorization", "Basic " + base64Creds);
        return new HttpEntity<>(headers);
    }

}
