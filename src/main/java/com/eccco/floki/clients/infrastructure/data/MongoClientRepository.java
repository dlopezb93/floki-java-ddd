package com.eccco.floki.clients.infrastructure.data;

import an.awesome.pipelinr.Pipeline;
import com.eccco.floki.clients.domain.Client;
import com.eccco.floki.clients.domain.ClientId;
import com.eccco.floki.clients.domain.ClientRepository;
import com.eccco.floki.shared.infrastructure.data.BaseRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

@Component
public class MongoClientRepository
        extends BaseRepository<Client, ClientId>
        implements ClientRepository {
    private static HashMap<String, Client> clients = new HashMap<>();
    private final int defaultAge = 30;

    public MongoClientRepository(Pipeline pipeline) {
        super(pipeline);
    }

    @Override
    public Optional<Client> getClientByName(String name) {
        return Optional.of(new Client("Daniel", defaultAge));
    }
}
