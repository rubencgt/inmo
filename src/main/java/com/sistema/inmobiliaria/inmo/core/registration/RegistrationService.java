package com.sistema.inmobiliaria.inmo.core.registration;

import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import com.sistema.inmobiliaria.inmo.domain.user.UserResponseDto;
import org.springframework.stereotype.Service;

/**
 * @author Ruben Guarachi
 */
@Service
public interface RegistrationService {

    void registerUserAccount(UserDto userDto);

}
