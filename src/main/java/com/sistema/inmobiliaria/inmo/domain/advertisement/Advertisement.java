package com.sistema.inmobiliaria.inmo.domain.advertisement;

import com.sistema.inmobiliaria.inmo.domain.common.VersionedEntity;
import com.sistema.inmobiliaria.inmo.domain.property.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "ID_GENERATOR", sequenceName = "ADVERTISEMENT_SEQ_ID", allocationSize = 100)
public class Advertisement extends VersionedEntity<Long> {


    private Property property;

    private AdvertisementType advertisementType;

    public AdvertisementType getAdvertisementType() {
        return advertisementType;
    }

    public void setAdvertisementType(AdvertisementType advertisementType) {
        this.advertisementType = advertisementType;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROPERTY_ID")
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
