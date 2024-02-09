package com.eccco.floki.clients.domain;

import com.eccco.floki.shared.domain.DomainEvent;

public class ClientCreatedEvent extends DomainEvent {
    public ClientCreatedEvent(String aggregateId) {
        super(aggregateId);
    }

    @Override
    public String eventName() {
        return "client_created";
    }
}
