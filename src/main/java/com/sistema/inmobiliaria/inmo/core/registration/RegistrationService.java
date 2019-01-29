package com.sistema.inmobiliaria.inmo.core.registration;

import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import com.sistema.inmobiliaria.inmo.domain.user.UserReponseDto;
import org.springframework.stereotype.Service;

/**
 * @author Ruben Guarachi
 */
@Service
public interface RegistrationService {

    UserReponseDto registerUserAccount(UserDto userDto);

}
