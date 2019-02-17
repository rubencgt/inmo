package com.sistema.inmobiliaria.inmo.steps;

import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementDto;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementType;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyType;
import com.sistema.inmobiliaria.inmo.rest.AdvertisementController;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static com.sistema.inmobiliaria.inmo.utils.DefaultEntities.createAdvertisementDto;

public class AdvertisementSteps extends StepsRestBaseIT {

    @When("the user creates a new add via rest")
    public void userInsertsAdd() {
        AdvertisementDto advertisement = createAdvertisementDto(AdvertisementType.ALQUILER, PropertyType.STORE);
        String url = createUrl(1L);

        ResponseEntity<?> responseEntity = auth2RestTemplate.postForEntity(url, advertisement, String.class);
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


}
