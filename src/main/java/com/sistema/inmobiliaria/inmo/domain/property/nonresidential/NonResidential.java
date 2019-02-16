package com.sistema.inmobiliaria.inmo.domain.property.nonresidential;

import com.sistema.inmobiliaria.inmo.domain.property.Property;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyType;

/**
 * @author Ruben Guarachi
 */
public abstract class NonResidential extends Property {

    NonResidential() {
    }

    NonResidential(String location, PropertyType type, String description) {
        super(location, type, description);
    }
}
