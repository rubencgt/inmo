package com.sistema.inmobiliaria.inmo.core.advertisement;

import com.sistema.inmobiliaria.inmo.domain.advertisement.Advertisement;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ruben Guarachi
 */
@Service
public interface AdvertisementService {

    void createAdvertisement(AdvertisementDto advertisementDto, Long userId);

    List<Advertisement> getAdvertisements(Long userId);
}
