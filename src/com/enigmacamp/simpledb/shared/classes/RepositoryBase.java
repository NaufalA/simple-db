package com.enigmacamp.simpledb.shared.classes;

import java.util.ArrayList;

public abstract class RepositoryBase<T> {
    public final ArrayList<T> storage;

    public RepositoryBase() {
        storage = new ArrayList<>();
    }

    public T add(T newItem) {
        storage.add(newItem);
        return newItem;
    }

    public T delete(T deletedItem) {
        storage.remove(deletedItem);
        return deletedItem;
    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(storage);
    }

    public T getOne(Integer index) {
        return storage.get(index);
    }

    public Integer getDataCount() {
        return storage.size();
    }
}
