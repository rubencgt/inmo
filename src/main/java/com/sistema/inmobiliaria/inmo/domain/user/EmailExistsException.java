package com.sistema.inmobiliaria.inmo.domain.user;

/**
 * @author Ruben Guarachi
 */
public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String message) {
        super(message);
    }

    public EmailExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
