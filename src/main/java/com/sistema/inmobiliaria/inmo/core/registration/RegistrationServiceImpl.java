package com.sistema.inmobiliaria.inmo.core.registration;

import com.sistema.inmobiliaria.inmo.domain.user.EmailExistsException;
import com.sistema.inmobiliaria.inmo.domain.user.User;
import com.sistema.inmobiliaria.inmo.domain.user.UserDto;
import com.sistema.inmobiliaria.inmo.domain.user.UserReponseDto;
import com.sistema.inmobiliaria.inmo.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * @author Ruben Guarachi
 */
@Component
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserReponseDto registerUserAccount(UserDto userDto) {

        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailExistsException("There is another already registered with this email: " + userDto.getEmail());
        }

        User user = new User(userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword())
        );
        userRepository.save(user);
        return new UserReponseDto();
    }

}
