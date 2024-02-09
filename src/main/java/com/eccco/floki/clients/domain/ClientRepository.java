package com.eccco.floki.clients.domain;

import com.eccco.floki.shared.domain.Repository;

import java.util.Optional;

public interface ClientRepository extends Repository<Client, ClientId> {
    Optional<Client> getClientByName(String name);
}
