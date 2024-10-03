package com.joshuadias.chat.base;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public abstract class AbstractServiceRepository<R extends GenericRepository<T, I>, T, I extends Serializable> {

    protected R repository;

    public T save(T entity) {
        return repository.save(entity);
    }
}
