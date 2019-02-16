package com.sistema.inmobiliaria.inmo.core;

/**
 * @author Ruben Guarachi
 */
public class InmoException extends RuntimeException {

    public InmoException(String message) {
        super(message);
    }

    public InmoException(String message, Throwable cause) {
        super(message, cause);
    }
}
