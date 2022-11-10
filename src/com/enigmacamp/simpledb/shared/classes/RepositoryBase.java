package com.enigmacamp.simpledb.shared.classes;

import com.enigmacamp.simpledb.shared.exceptions.CapacityLimitException;
import com.enigmacamp.simpledb.shared.exceptions.EmptyDatabaseException;
import com.enigmacamp.simpledb.shared.interfaces.Repository;

import java.util.ArrayList;

public abstract class RepositoryBase<T> implements Repository<T> {
    protected final ArrayList<T> storage;
    protected final Integer maxSize;

    public RepositoryBase(Integer maxSize) {
        storage = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public T add(T newItem) throws CapacityLimitException {
        if (storage.size() >= maxSize) {
            throw new CapacityLimitException();
        }

        storage.add(newItem);
        return newItem;
    }

    public T delete(Integer index) throws EmptyDatabaseException {
        if (storage.isEmpty()) {
            throw new EmptyDatabaseException();
        }
        T deletedItem = getOne(index);
        storage.remove(deletedItem);
        return deletedItem;
    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(storage);
    }

    public T getOne(Integer index) {
        return storage.get(index);
    }

    public Integer getSize() {
        return storage.size();
    }
}
