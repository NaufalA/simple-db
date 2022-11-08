package com.enigmacamp.simpledb.shared.classes;

import java.util.ArrayList;

public abstract class ServiceBase<T> {
    public final RepositoryBase<T> repository;
    public final int storageSize;

    public ServiceBase(RepositoryBase<T> repository, int storageSize) {
        this.repository = repository;
        this.storageSize = storageSize;
    }

    public T createItem(T newItem) throws Exception {
        if (repository.getDataCount() < storageSize) {
            repository.add(newItem);
            return newItem;
        } else {
            throw new Exception("Database Penuh!");
        }
    }

    public T removeItem(Integer deletedIndex) throws Exception {
        if (deletedIndex == -1) {
            throw new Exception("Database Sudah Kosong!");
        }
        T deletedItem = getOne(deletedIndex);
        repository.delete(deletedItem);
        return deletedItem;
    }

    public ArrayList<T> getAllItem() {
        return repository.getAll();
    }

    public T getOne(Integer index) throws Exception {
        if (index < 0 || index >= getDataCount()) {
            throw new Exception("Index Tidak Valid!");
        }
        return repository.getOne(index);
    }


    public Integer getDataCount() {
        return repository.getDataCount();
    }
}
