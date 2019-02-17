package com.sistema.inmobiliaria.inmo.domain.advertisement;

import com.sistema.inmobiliaria.inmo.domain.property.PropertyDto;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Ruben Guarachi
 */
@Data
public class AdvertisementDto {

    @NotNull
    private PropertyDto propertyDto;

    @NotNull
    private AdvertisementType advertisementType;

}
