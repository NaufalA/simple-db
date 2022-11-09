package com.enigmacamp.simpledb.shared.interfaces;

import java.util.List;

public interface Repository<T> {
    T add(T newItem) throws Exception;

    T delete(Integer index) throws Exception;

    List<T> getAll();

    T getOne(Integer index);

    Integer getSize();
}
