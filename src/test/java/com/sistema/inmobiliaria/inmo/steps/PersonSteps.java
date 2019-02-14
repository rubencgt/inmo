package com.sistema.inmobiliaria.inmo.Steps;

import com.sistema.inmobiliaria.inmo.domain.user.Person;
import com.sistema.inmobiliaria.inmo.domain.user.PersonRepository;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static com.sistema.inmobiliaria.inmo.utils.DefaultEntities.unique_email;

public class PersonSteps extends StepsRestBaseIT {

    @Autowired
    private PersonRepository personRepository;

    @Given("a new person")
    public void personIsCreated() {
        Person person = new Person("some name", "name", unique_email());
        personRepository.save(person);
        cucumberContext.setCustomerId(person.getId());
    }


    @Then("the person audit fields are filled")
    public void personAuditFieldsAreFilled() {
        Person person = personRepository.findById(cucumberContext.getCustomerId());
        assert person.getCreationDate() != null;
        assert person.getCreatedBy() != null;
    }
}
