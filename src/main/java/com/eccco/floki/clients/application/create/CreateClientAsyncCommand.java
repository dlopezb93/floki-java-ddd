package com.eccco.floki.clients.application.create;

import an.awesome.pipelinr.Command;
import com.eccco.floki.clients.application.dtos.ClientDto;
import com.eccco.floki.clients.application.dtos.CreateClientDto;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;

@Getter
public class CreateClientAsyncCommand implements Command<CompletableFuture<ClientDto>> {
    private final CreateClientDto payload;

    public CreateClientAsyncCommand(CreateClientDto payload) {
        this.payload = payload;
    }
}
