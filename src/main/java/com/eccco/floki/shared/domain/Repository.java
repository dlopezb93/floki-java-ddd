package com.eccco.floki.shared.domain;

import java.util.concurrent.CompletableFuture;

public interface Repository<TEntity extends AggregateRoot, TKey> {
    void save(TEntity entity);

    CompletableFuture<Void> saveAsync(TEntity entity);
}
