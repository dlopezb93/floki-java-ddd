package com.eccco.floki.shared.domain;

import an.awesome.pipelinr.Notification;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class DomainEvent implements Notification {
    private String aggregateId;
    private String eventId;
    private String occurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId     = UUID.randomUUID().toString();
        this.occurredOn  = Utils.dateToString(LocalDateTime.now());
    }

    protected DomainEvent() {
    }

    public abstract String eventName();

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String occurredOn() {
        return occurredOn;
    }
}
