package com.sistema.inmobiliaria.inmo.domain.property;

import com.sistema.inmobiliaria.inmo.domain.common.VersionedEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "PROPERTY_SEQ_ID", allocationSize = 100)
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Property extends VersionedEntity<Long> {

    private String location;

    private PropertyType type;

    private String description;

}
