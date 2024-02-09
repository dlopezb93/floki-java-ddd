package com.eccco.floki.clients.domain;

import com.eccco.floki.shared.domain.AggregateRoot;
import lombok.Getter;

@Getter
public class Client extends AggregateRoot {
    private ClientId clientId;
    private String name;
    private int age;

    public Client(String name, int age) {
        this.clientId = ClientId.generate();
        this.name = name;
        this.age = age;

        this.record(new ClientCreatedEvent(this.clientId.value()));
    }

    @Override
    public String getIdentifier() {
        return clientId.value();
    }
}
