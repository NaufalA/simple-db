package com.enigmacamp.simpledb.shared.classes;

import com.enigmacamp.simpledb.shared.interfaces.Repository;
import com.enigmacamp.simpledb.shared.interfaces.Service;

import java.util.List;

public abstract class ServiceBase<T> implements Service<T> {
    public final Repository<T> repository;

    public ServiceBase(Repository<T> repository) {
        this.repository = repository;
    }

    public T createItem(T newItem) throws Exception {
        repository.add(newItem);
        return newItem;
    }

    public T removeItem(Integer deletedIndex) throws Exception {
        return repository.delete(deletedIndex);
    }

    public List<T> getAll() {
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
