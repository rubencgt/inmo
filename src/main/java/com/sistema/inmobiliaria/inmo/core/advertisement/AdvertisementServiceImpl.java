package com.sistema.inmobiliaria.inmo.core.advertisement;

import com.sistema.inmobiliaria.inmo.core.InmoException;
import com.sistema.inmobiliaria.inmo.domain.advertisement.Advertisement;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementDto;
import com.sistema.inmobiliaria.inmo.domain.advertisement.AdvertisementRepository;
import com.sistema.inmobiliaria.inmo.domain.property.Property;
import com.sistema.inmobiliaria.inmo.domain.property.PropertyRepository;
import com.sistema.inmobiliaria.inmo.domain.user.User;
import com.sistema.inmobiliaria.inmo.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Ruben Guarachi
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyFactory propertyFactory;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    @Transactional
    public void createAdvertisement(AdvertisementDto advertisementDto, Long userId) {
        userRepository.findById(userId)
                .ifPresent(user -> {
                    Property property = propertyFactory.createProperty(advertisementDto.getPropertyDto());
                    propertyRepository.save(property);
                    Advertisement advertisement = new Advertisement(property, advertisementDto.getAdvertisementType());
                    advertisementRepository.save(advertisement);
                    user.getAdvertisements().add(advertisement);
                    userRepository.save(user);
                });
    }

    @Override
    public List<Advertisement> getAdvertisements(Long userId) {
        return userRepository.findById(userId)
                .map(User::getAdvertisements)
                .orElseThrow(() -> new InmoException("User not found id: " + userId));
    }

}
