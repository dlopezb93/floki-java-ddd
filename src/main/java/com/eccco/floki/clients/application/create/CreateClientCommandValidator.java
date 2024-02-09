package com.eccco.floki.clients.application.create;

import com.eccco.floki.clients.application.dtos.ClientDto;
import com.eccco.floki.shared.application.pipelinr.CommandValidator;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class CreateClientCommandValidator implements CommandValidator<CreateClientCommand, ClientDto> {
    @Override
    public void validate(CreateClientCommand command) {
        System.out.println(
                MessageFormat.format("----- Validating command {0} -----", command.getClass().getSimpleName()));
    }
}
