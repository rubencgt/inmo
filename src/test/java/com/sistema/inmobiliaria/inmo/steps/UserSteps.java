package com.sistema.inmobiliaria.inmo.steps;

import com.sistema.inmobiliaria.inmo.domain.user.User;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import com.sistema.inmobiliaria.inmo.domain.user.UserRepository;
import com.sistema.inmobiliaria.inmo.rest.UserController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class UserSteps extends StepsRestBaseIT {

    @Autowired
    private UserRepository userRepository;

    @Given("a new user is registered")
    public void personIsCreated() {
        if (Objects.isNull(cucumberContext.getTestUser())) {
            UserDto userDto = createUserDto();
            restTemplate.postForEntity(inmoUrlBase + UserController.BASE_URL, userDto, UserDto.class);
            cucumberContext.setTestUser(userDto);
        }
    }

    @Then("the user can access authorized resources")
    public void personAccessPrivateResources() {
        ResponseEntity<String> responseEntity2 = auth2RestTemplate.getForEntity(inmoUrlBase + "/user", String.class);
        assert responseEntity2.getStatusCode().is2xxSuccessful();
        assert Objects.equals(responseEntity2.getBody(), "Logged in from /user");
    }


    @Then("the person audit fields are filled")
    public void personAuditFieldsAreFilled() {
        User user = userRepository.findUserByEmail(cucumberContext.getTestUser().getEmail()).get();
        assert user.getCreationDate() != null;
        assert user.getCreatedBy() != null;
    }
}
