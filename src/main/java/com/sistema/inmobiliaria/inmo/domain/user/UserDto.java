package com.sistema.inmobiliaria.inmo.domain.user;

import com.sistema.inmobiliaria.inmo.domain.user.validation.PasswordMatches;
import com.sistema.inmobiliaria.inmo.domain.user.validation.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Ruben Guarachi
 */
@Data
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

}
