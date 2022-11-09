package com.enigmacamp.simpledb.shared.classes;

import com.enigmacamp.simpledb.shared.interfaces.Repository;

import java.util.ArrayList;

public abstract class RepositoryBase<T> implements Repository<T> {
    public final ArrayList<T> storage;
    public final Integer maxSize;

    public RepositoryBase(Integer maxSize) {
        storage = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public T add(T newItem) throws Exception {
        if (storage.size() >= maxSize) {
            throw new Exception("Database Penuh!");
        }

        storage.add(newItem);
        return newItem;
    }

    public T delete(Integer index) throws Exception {
        if (storage.isEmpty()) {
            throw new Exception("Database Sudah Kosong!");
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
