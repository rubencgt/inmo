package com.sistema.inmobiliaria.inmo.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author Ruben Guarachi
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .map(user -> new org.springframework.security.core.userdetails.User(user.getEmail(),
                        user.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority(ROLE_USER)))
                )
                .orElseThrow(() -> new UsernameNotFoundException(email + " not found"));

    }
}
