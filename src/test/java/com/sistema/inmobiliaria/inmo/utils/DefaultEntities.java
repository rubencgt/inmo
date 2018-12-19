package com.sistema.inmobiliaria.inmo.utils;

import java.util.UUID;

public class DefaultEntities {

    public static String unique_email() {
        return UUID.randomUUID().getMostSignificantBits() + "@email.com";
    }
}
