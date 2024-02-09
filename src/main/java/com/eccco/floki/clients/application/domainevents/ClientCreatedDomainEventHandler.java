package com.eccco.floki.clients.application.domainevents;

import an.awesome.pipelinr.Notification;
import com.eccco.floki.clients.domain.ClientCreatedEvent;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class ClientCreatedDomainEventHandler implements Notification.Handler<ClientCreatedEvent> {
    @Override
    public void handle(ClientCreatedEvent clientCreatedEvent) {
        if (clientCreatedEvent != null) {
            String eventName = clientCreatedEvent.eventName();
            System.out.println(MessageFormat.format("Received domain event: {0}", eventName));
        }
    }
}
