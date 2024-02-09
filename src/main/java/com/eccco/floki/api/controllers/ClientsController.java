package com.eccco.floki.api.controllers;

import an.awesome.pipelinr.Pipeline;
import com.eccco.floki.clients.application.create.CreateClientCommand;
import com.eccco.floki.clients.application.dtos.ClientDto;
import com.eccco.floki.clients.application.dtos.CreateClientDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientsController {

    private final Pipeline pipeline;

    public ClientsController(Pipeline pipelinr) {
        this.pipeline = pipelinr;
    }

    @PostMapping("/clients/")
    public ResponseEntity<ClientDto> createClient(@RequestBody CreateClientDto body) { // fafsssssssssffffffgggfgfdsgfdsgfdsgfdsgds
        var command = new CreateClientCommand(body);
        var response = pipeline.send(command);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
