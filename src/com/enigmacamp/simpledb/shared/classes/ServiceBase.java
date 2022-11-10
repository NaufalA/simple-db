package com.enigmacamp.simpledb.shared.classes;

import com.enigmacamp.simpledb.shared.exceptions.CapacityLimitException;
import com.enigmacamp.simpledb.shared.exceptions.InvalidDataException;
import com.enigmacamp.simpledb.shared.interfaces.Service;

import java.util.ArrayList;

public abstract class ServiceBase<T> implements Service<T> {
    public final RepositoryBase<T> repository;

    public ServiceBase(RepositoryBase<T> repository) {
        this.repository = repository;
    }

    public T createItem(T newItem) throws InvalidDataException, CapacityLimitException {
        repository.add(newItem);
        return newItem;
    }

    public T removeItem(Integer deletedIndex) throws Exception {
        return repository.delete(deletedIndex);
    }

    public ArrayList<T> getAll() {
        return repository.getAll();
    }

    public T getOne(Integer index) throws Exception {
        if (index < 0 || index >= getDataCount()) {
            throw new Exception("Index Tidak Valid!");
        }
        return repository.getOne(index);
    }


    public Integer getDataCount() {
        return repository.getSize();
    }
}
