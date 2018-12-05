package com.sistema.inmobiliaria.inmo.Steps;

import com.sistema.inmobiliaria.inmo.config.CucumberContext;
import com.sistema.inmobiliaria.inmo.domain.Person;
import com.sistema.inmobiliaria.inmo.domain.PersonRepository;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonSteps extends StepsRestBaseIT {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CucumberContext cucumberContext;

    @When("a new person is created")
    public void personIsCreated() {
        Person person = new Person("some name", "name");
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
