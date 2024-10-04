package com.joshuadias.chat.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class AbstractService<R extends GenericRepository<T, I>, M extends GenericMapper, T, I extends Serializable> {

    @Autowired(required = false)
    protected R repository;

    @Autowired(required = false)
    protected M mapper;

    public T save(T entity) {
        return repository.save(entity);
    }
}
