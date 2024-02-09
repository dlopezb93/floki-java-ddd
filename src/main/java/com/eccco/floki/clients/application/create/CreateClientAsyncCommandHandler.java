package com.eccco.floki.clients.application.create;

import an.awesome.pipelinr.Command;
import com.eccco.floki.clients.application.dtos.ClientDto;
import com.eccco.floki.clients.application.mappers.ClientMapper;
import com.eccco.floki.clients.domain.Client;
import com.eccco.floki.clients.domain.ClientRepository;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CreateClientAsyncCommandHandler implements Command.Handler<CreateClientAsyncCommand, CompletableFuture<ClientDto>> {
    private final ClientRepository repository;
    private final ClientMapper mapper;

    public CreateClientAsyncCommandHandler(
            ClientRepository repository,
            ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CompletableFuture<ClientDto> handle(CreateClientAsyncCommand createClientAsyncCommand) {
        Supplier<ClientDto> supplier = () -> {
            var client = new Client(
                    createClientAsyncCommand.getPayload().getName(),
                    createClientAsyncCommand.getPayload().getAge());

            repository.save(client);

            return mapper.toDto(client);
        };
        var client = new Client(
                createClientAsyncCommand.getPayload().getName(),
                createClientAsyncCommand.getPayload().getAge());

        return repository.saveAsync(client).thenApply((Void) -> mapper.toDto(client));
    }
}
