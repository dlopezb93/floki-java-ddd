package com.eccco.floki.clients.domain;

import com.eccco.floki.shared.domain.Identifier;

import java.util.UUID;

public final class ClientId extends Identifier {
    private ClientId(String value) {
        super(value);
    }

    public static ClientId generate() {
        return  new ClientId(UUID.randomUUID().toString());
    }
}
