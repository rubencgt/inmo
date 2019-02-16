package com.sistema.inmobiliaria.inmo.domain.property;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Ruben Guarachi
 */
@Data
public class PropertyDto {

    @NotNull
    private String location;

    @NotNull
    private PropertyType type;

    @NotNull
    private String description;

}
