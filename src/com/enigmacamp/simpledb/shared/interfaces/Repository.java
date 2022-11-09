package com.enigmacamp.simpledb.shared.interfaces;

import java.util.List;

public interface Repository<T> {
    T add(T newItem);

    T delete(T deletedItem);

    List<T> getAll();

    T getOne(Integer index);

    Integer getDataCount();
}
