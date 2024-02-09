package com.eccco.floki.clients.application.create;

import an.awesome.pipelinr.Command;
import com.eccco.floki.clients.application.dtos.ClientDto;
import com.eccco.floki.clients.application.dtos.CreateClientDto;
import lombok.Getter;

@Getter
public final class CreateClientCommand implements Command<ClientDto> {
    private final CreateClientDto payload;

    public CreateClientCommand(CreateClientDto payload) {
        this.payload = payload;
    }
}
