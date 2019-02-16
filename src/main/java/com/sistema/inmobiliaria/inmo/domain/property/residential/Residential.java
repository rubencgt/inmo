package com.sistema.inmobiliaria.inmo.domain.property.residential;

import com.sistema.inmobiliaria.inmo.domain.property.Property;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyType;

/**
 * @author Ruben Guarachi
 */
abstract class Residential extends Property {

    Residential() {
    }

    Residential(String location, PropertyType type, String description) {
        super(location, type, description);
    }

}
