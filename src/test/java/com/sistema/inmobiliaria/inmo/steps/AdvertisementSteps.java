package com.sistema.inmobiliaria.inmo.steps;

import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementDto;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementType;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyDto;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyType;
import com.sistema.inmobiliaria.inmo.rest.AdvertisementController;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public class AdvertisementSteps extends StepsRestBaseIT {

    @When("the user creates a new add via rest")
    public void userInsertsAdd() {
        AdvertisementDto advertisement = createAdvertisementDto(AdvertisementType.ALQUILER, PropertyType.STORE);
        String url = createUrl(1L);

        ResponseEntity<String> responseEntity = auth2RestTemplate.postForEntity(url, advertisement, String.class);
        assert responseEntity.getStatusCode().is2xxSuccessful();
    }

    @Then("the user can retrieve his advertisements")
    public void advertisementAvailable() {
        String url = createUrl(1L);

        ResponseEntity<?> responseEntity = restTemplate.getForEntity(url, String.class);
        assert responseEntity.getStatusCode().is2xxSuccessful();
    }

    private String createUrl(Long userId) {
        return UriComponentsBuilder.fromUriString(inmoUrlBase + AdvertisementController.BASE_URL)
                .queryParam("userId", userId)
                .build().toString();
    }

    private AdvertisementDto createAdvertisementDto(AdvertisementType advertisementType, PropertyType propertyType) {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setDescription("description");
        propertyDto.setLocation("some location");
        propertyDto.setType(propertyType);

        AdvertisementDto advertisement = new AdvertisementDto();
        advertisement.setAdvertisementType(advertisementType);
        advertisement.setPropertyDto(propertyDto);
        return advertisement;
    }
}
