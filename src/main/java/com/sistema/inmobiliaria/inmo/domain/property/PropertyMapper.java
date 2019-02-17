package com.sistema.inmobiliaria.inmo.domain.property;

import org.mapstruct.Mapper;

/**
 * @author Ruben Guarachi
 */
@Mapper
public interface PropertyMapper {

    PropertyDto toDto(Property property);

    Property toEntity(PropertyDto dto);

}
