package com.sistema.inmobiliaria.inmo.core.advertisement;

import com.sistema.inmobiliaria.inmo.core.InmoException;
import com.sistema.inmobiliaria.inmo.domain.property.Property;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyDto;
import com.sistema.inmobiliaria.inmo.domain.property.nonresidential.Office;
import com.sistema.inmobiliaria.inmo.domain.property.nonresidential.Parcel;
import com.sistema.inmobiliaria.inmo.domain.property.nonresidential.Store;
import com.sistema.inmobiliaria.inmo.domain.property.residential.Apartment;
import com.sistema.inmobiliaria.inmo.domain.property.residential.House;
import com.sistema.inmobiliaria.inmo.domain.property.residential.Room;
import org.springframework.stereotype.Component;

/**
 * @author Ruben Guarachi
 */
@Component
public class PropertyFactory {

    public Property createProperty(PropertyDto dto) {

        switch (dto.getType()) {
            case HOUSE:
                return new House(dto.getLocation(), dto.getType(), dto.getDescription());
            case APARTMENT:
                return new Apartment(dto.getLocation(), dto.getType(), dto.getDescription());
            case ROOM:
                return new Room(dto.getLocation(), dto.getType(), dto.getDescription());
            case OFFICE:
                return new Office(dto.getLocation(), dto.getType(), dto.getDescription());
            case STORE:
                return new Store(dto.getLocation(), dto.getType(), dto.getDescription());
            case PARCEL:
                return new Parcel(dto.getLocation(), dto.getType(), dto.getDescription());
            default:
                throw new InmoException("Property type: " + dto.getType() + " not supported");
        }
    }

}
