package com.sistema.inmobiliaria.inmo.domain.property.residential;

import com.sistema.inmobiliaria.inmo.domain.property.PropertyType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * this class is not designed for extension
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "PROPERTY_ID")
@Data
@NoArgsConstructor
public final class House extends Residential {

    public House(String location, PropertyType type, String description) {
        super(location, type, description);
    }

}
