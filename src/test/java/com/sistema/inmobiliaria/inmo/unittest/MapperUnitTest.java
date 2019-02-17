package com.sistema.inmobiliaria.inmo.unittest;

import com.sistema.inmobiliaria.inmo.domain.advertisement.Advertisement;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementDto;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementMapper;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementType;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyType;
import com.sistema.inmobiliaria.inmo.utils.DefaultEntities;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

/**
 * @author Ruben Guarachi
 */

public class MapperUnitTest {

    private AdvertisementMapper mapper = Mappers.getMapper(AdvertisementMapper.class);

    @Test
    public void AdvertisementMapperTest() {

        AdvertisementDto advertisementDto = DefaultEntities.createAdvertisementDto(AdvertisementType.VENTA, PropertyType.APARTMENT);

        Advertisement advertisement = mapper.toEntity(advertisementDto);

        assert Objects.nonNull(advertisement);
        assert Objects.nonNull(advertisement.getProperty());
        assert advertisement.getProperty().getType() == advertisement.getProperty().getType();

    }
}
