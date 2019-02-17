package com.sistema.inmobiliaria.inmo.core.advertisement;

import com.sistema.inmobiliaria.inmo.domain.advertisement.Advertisement;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementDto;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementMapper;
import com.sistema.inmobiliaria.inmo.domain.property.Property;
import com.sistema.inmobiliaria.inmo.domain.user.User;
import com.sistema.inmobiliaria.inmo.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ruben Guarachi
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyFactory propertyFactory;

    @Override
    @Transactional
    public void createAdvertisement(AdvertisementDto advertisementDto, Long userId) {
        userRepository.findById(userId)
                .ifPresent(user -> {
                    Property property = propertyFactory.createProperty(advertisementDto.getPropertyDto());
                    Advertisement advertisement = new Advertisement(property, advertisementDto.getAdvertisementType());
                    user.getAdvertisements().add(advertisement);
                    userRepository.save(user);
                });
    }

    @Override
    public List<AdvertisementDto> getAdvertisements(Long userId) {
        return userRepository.findById(userId)
                .stream()
                .map(User::getAdvertisements)
                .flatMap(Collection::stream)
                .map(AdvertisementMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }


}
