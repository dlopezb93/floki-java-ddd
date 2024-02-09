package com.eccco.floki.clients.application.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateClientDto {
    private String name;
    private int age;
}
