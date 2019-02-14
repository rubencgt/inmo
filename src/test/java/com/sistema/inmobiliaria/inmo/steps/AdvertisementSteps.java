package com.sistema.inmobiliaria.inmo.steps;

import com.sistema.inmobiliaria.inmo.domain.advertisement.Advertisement;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementRepository;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementType;
import com.sistema.inmobiliaria.inmo.domain.property.House;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class AdvertisementSteps extends StepsRestBaseIT {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Given("a new advertisement")
    public void personIsCreated() {
        House property = new House("house", "house", "house");

        Advertisement advertisement = new Advertisement(property, AdvertisementType.ALQUILER);

        advertisementRepository.save(advertisement);
    }

}
