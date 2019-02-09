package com.sistema.inmobiliaria.inmo.steps;

import com.sistema.inmobiliaria.inmo.domain.user.User;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import com.sistema.inmobiliaria.inmo.domain.user.UserRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class PersonSteps extends StepsRestBaseIT {

    @Autowired
    private UserRepository userRepository;

    @Given("a new person is registered")
    public void personIsCreated() {
        UserDto userDto = createUserDto();
        restTemplate.postForEntity(restBase + "/registration", userDto, UserDto.class);
        cucumberContext.setTestUser(userDto);
    }

    @When("the person logs in")
    public void personLogsIn() {
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(cucumberContext.getTestUser().getEmail(), cucumberContext.getTestUser().getPassword()));
        Map<String, String> parameters = new HashMap<>();
        parameters.put("username", cucumberContext.getTestUser().getEmail());
        parameters.put("password", cucumberContext.getTestUser().getPassword());
        ResponseEntity<HttpSession> session = restTemplate.postForEntity(restBase + "/login", null, HttpSession.class, parameters);

        ResponseEntity<String> result = restTemplate.exchange(restBase + "/user", HttpMethod.GET, null, String.class);
        System.out.println(result.getBody());

        ResponseEntity<String> responseEntity2 = restTemplate.getForEntity(restBase + "/todos", String.class);
        System.out.println(responseEntity2.getBody());
    }

    @Then("the person audit fields are filled")
    public void personAuditFieldsAreFilled() {
        User user = userRepository.findUserByEmail(cucumberContext.getTestUser().getEmail()).get();
        assert user.getCreationDate() != null;
        assert user.getCreatedBy() != null;
        assert user.getLastModifiedBy() == null;
        assert user.getLastModifiedDate() == null;
    }

    private UserDto createUserDto() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("Some name");
        userDto.setLastName("Some last name");
        userDto.setEmail("some@email.com");
        userDto.setPassword("password");
        userDto.setMatchingPassword("password");
        return userDto;
    }
}
