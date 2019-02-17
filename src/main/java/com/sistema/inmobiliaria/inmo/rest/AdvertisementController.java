package com.sistema.inmobiliaria.inmo.rest;

import com.sistema.inmobiliaria.inmo.core.advertisement.AdvertisementService;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Ruben Guarachi
 */

@RestController
public class AdvertisementController {

    public static final String BASE_URL = "/advertisements";

    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping(BASE_URL)
    public void createAdd(@RequestBody @Valid AdvertisementDto advertisementDto, @RequestParam Long userId) {
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        advertisementService.createAdvertisement(advertisementDto, userId);
    }

    @GetMapping(BASE_URL)
    public List<AdvertisementDto> getAll(@RequestParam long userId) {
        return advertisementService.getAdvertisements(userId);
    }

}

