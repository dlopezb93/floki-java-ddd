package com.eccco.floki.shared.infrastructure.data;

import an.awesome.pipelinr.Pipeline;
import com.eccco.floki.shared.domain.AggregateRoot;
import com.eccco.floki.shared.domain.DomainEvent;
import com.eccco.floki.shared.domain.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class BaseRepository<TEntity extends AggregateRoot, TKey>
        implements Repository<TEntity, TKey> {

    protected HashMap<String, TEntity> memory = new HashMap<>();
    private final Pipeline pipeline;

    public BaseRepository(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public void save(TEntity entity) {
        memory.put(entity.getIdentifier(), entity);
        dispatchDomainEvents(entity);
    }

    @Override
    public CompletableFuture<Void> saveAsync(TEntity entity) {
        memory.put(entity.getIdentifier(), entity);
        dispatchDomainEvents(entity);

        return  CompletableFuture.completedFuture(null);
    }

    private void dispatchDomainEvents(AggregateRoot entity) {
        List<DomainEvent> events = entity.pullDomainEvents();

        if (events == null) {
            return;
        }

        events.forEach(pipeline::send);
    }
}
