package com.eccco.floki.clients.application.mappers;

import com.eccco.floki.clients.application.dtos.ClientDto;
import com.eccco.floki.clients.domain.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "clientId", expression = "java(client.getIdentifier())")
    ClientDto toDto(Client client);
}
