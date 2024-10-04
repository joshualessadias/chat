package com.joshuadias.chat.base;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public abstract class AbstractService<R extends GenericRepository<T, I>, M extends GenericMapper, T, I extends Serializable> {

    protected R repository;

    protected M mapper;

    public T save(T entity) {
        return repository.save(entity);
    }
}
