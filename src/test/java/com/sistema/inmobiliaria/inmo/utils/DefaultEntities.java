package com.sistema.inmobiliaria.inmo.utils;

import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementDto;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementType;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyDto;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyType;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;

import java.util.UUID;

public class DefaultEntities {

    public static String unique_email() {
        return UUID.randomUUID().getMostSignificantBits() + "@email.com";
    }

    public static UserDto createUserDto() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("Some name");
        userDto.setLastName("Some last name");
        userDto.setEmail("some@email.com");
        userDto.setPassword("password");
        userDto.setMatchingPassword("password");
        return userDto;
    }

    public static AdvertisementDto createAdvertisementDto(AdvertisementType advertisementType, PropertyType propertyType) {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setDescription("description");
        propertyDto.setLocation("some location");
        propertyDto.setType(propertyType);

        AdvertisementDto advertisement = new AdvertisementDto();
        advertisement.setAdvertisementType(advertisementType);
        advertisement.setPropertyDto(propertyDto);
        return advertisement;
    }
}
