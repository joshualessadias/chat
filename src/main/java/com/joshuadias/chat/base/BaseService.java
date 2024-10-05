package com.joshuadias.chat.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class BaseService<R extends GenericRepository<T, I>, T, I extends Serializable> {

    @Autowired(required = false)
    protected R repository;

    public T save(T entity) {
        return repository.save(entity);
    }
}
