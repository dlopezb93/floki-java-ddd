package com.eccco.floki.clients.application.create;

import an.awesome.pipelinr.Command;
import com.eccco.floki.clients.application.dtos.ClientDto;
import com.eccco.floki.clients.application.mappers.ClientMapper;
import com.eccco.floki.clients.domain.Client;
import com.eccco.floki.clients.domain.ClientRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateClientCommandHandler implements Command.Handler<CreateClientCommand, ClientDto> {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public CreateClientCommandHandler(
            ClientRepository clientRepository,
            ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDto handle(CreateClientCommand createClientCommand) {
        var client = new Client(
                createClientCommand.getPayload().getName(),
                createClientCommand.getPayload().getAge());

        clientRepository.save(client);

        return clientMapper.toDto(client);
    }
}
