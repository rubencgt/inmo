package com.sistema.inmobiliaria.inmo.core;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

public class IdGenerator {

    //TODO look for a better implementation of a UID e.g. snowflake
    public static long getLongId() {
        long val = -1;
        do {
            final UUID uuid = UUID.randomUUID();
            final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
            buffer.putLong(uuid.getLeastSignificantBits());
            buffer.putLong(uuid.getMostSignificantBits());
            final BigInteger bi = new BigInteger(buffer.array());
            val = bi.longValue();
        } while (val < 0);
        return val;
    }
}

