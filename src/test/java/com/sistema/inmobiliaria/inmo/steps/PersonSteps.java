package com.sistema.inmobiliaria.inmo.steps;

import com.sistema.inmobiliaria.inmo.domain.user.User;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import com.sistema.inmobiliaria.inmo.domain.user.UserRepository;
import com.sistema.inmobiliaria.inmo.rest.RegistrationController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class PersonSteps extends StepsRestBaseIT {

    @Autowired
    private UserRepository userRepository;

    @Given("a new person is registered")
    public void personIsCreated() {
        UserDto userDto = createUserDto();
        restTemplate.postForEntity(inmoUrlBase + RegistrationController.BASE_URL, userDto, UserDto.class);
        cucumberContext.setTestUser(userDto);
    }

    @Then("the person can access authorized resources")
    public void personAccessPrivateResources() throws JSONException {
        HttpEntity<?> entity = new HttpEntity<>("parameters", getHeadersWithToken(cucumberContext.getTestUser().getEmail(), cucumberContext.getTestUser().getPassword()));
        ResponseEntity<String> responseEntity2 = restTemplate.exchange(inmoUrlBase + "/user", HttpMethod.GET, entity, String.class);
        assert responseEntity2.getStatusCode().is2xxSuccessful();
        assert Objects.equals(responseEntity2.getBody(), "Logged in from /user");
    }


    @Then("the person audit fields are filled")
    public void personAuditFieldsAreFilled() {
        User user = userRepository.findUserByEmail(cucumberContext.getTestUser().getEmail()).get();
        assert user.getCreationDate() != null;
        assert user.getCreatedBy() != null;
        assert user.getLastModifiedBy() == null;
        assert user.getLastModifiedDate() == null;
    }
}
