package com.sistema.inmobiliaria.inmo.domain.advertisement;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Ruben Guarachi
 */
@Mapper
public interface AdvertisementMapper {

    AdvertisementMapper INSTANCE = Mappers.getMapper( AdvertisementMapper.class );

    @Mapping(source = "property", target = "propertyDto")
    AdvertisementDto toDto(Advertisement advertisement);

    @Mapping(source = "propertyDto", target = "property")
    Advertisement toEntity(AdvertisementDto advertisementDto);

}
