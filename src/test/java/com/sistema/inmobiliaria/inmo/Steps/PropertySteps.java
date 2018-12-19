package com.sistema.inmobiliaria.inmo.Steps;

import com.sistema.inmobiliaria.inmo.domain.property.House;
import com.sistema.inmobiliaria.inmo.domain.property.Property;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyRepository;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PropertySteps extends StepsRestBaseIT {

    @Autowired
    private PropertyRepository propertyRepository;

    @When("the user inserts a new house")
    public void userInsertsNewProperty() {
        Property property = new House("some location", "house", "a house description");
        propertyRepository.save(property);
        cucumberContext.setPropertyId(property.getId());
    }

    @Then("the user is able to retrieve the new house")
    public void userIsAbleToRetrieveTheProperty() {
        Optional<Property> property = propertyRepository.findById(cucumberContext.getPropertyId());
        assert property.isPresent();
    }
}