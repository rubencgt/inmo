package com.sistema.inmobiliaria.inmo.Steps;

import com.sistema.inmobiliaria.inmo.domain.Person;
import com.sistema.inmobiliaria.inmo.domain.PersonRepository;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonSteps extends StepsRestBase {

    @Autowired
    private PersonRepository personRepository;

    @When("a new person is created")
    public void personIsCreated() {
        Person person = new Person(2, "some name", "name");
        personRepository.save(person);
    }


    @Then("the person audit fields are filled")
    public void personAuditFieldsAreFilled() {
        Person person = personRepository.getOne(2L);
        assert person.getCreationDate() != null;
        assert person.getCreatedBy() != null;
    }
}
