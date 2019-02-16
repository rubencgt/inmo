package com.sistema.inmobiliaria.inmo.steps;

import com.sistema.inmobiliaria.inmo.domain.property.residential.House;
import com.sistema.inmobiliaria.inmo.domain.property.Property;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyRepository;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyType;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PropertySteps extends StepsRestBaseIT {

    @Autowired
    private PropertyRepository propertyRepository;

    @When("the user inserts a new house")
    public void userInsertsNewProperty() {
        Property property = new House("some location", PropertyType.HOUSE, "a house description");
        propertyRepository.save(property);
        cucumberContext.setPropertyId(property.getId());
    }

    @Then("the user is able to retrieve the new house")
    public void userIsAbleToRetrieveTheProperty() {
        Optional<Property> property = propertyRepository.findById(cucumberContext.getPropertyId());
        assert property.isPresent();
    }
}
