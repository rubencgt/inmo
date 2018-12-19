package com.sistema.inmobiliaria.inmo.domain.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@EqualsAndHashCode(callSuper = true)
@Entity
@PrimaryKeyJoinColumn(name = "PROPERTY_ID")
@Data
@NoArgsConstructor
public class House extends Property {
    public House(String location, String type, String description) {
        super(location, type, description);
    }
}
