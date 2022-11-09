package com.enigmacamp.simpledb.shared.interfaces;

import java.util.List;

public interface Service<T> {
    T createItem(T newItem) throws Exception;

    T removeItem(Integer deletedIndex) throws Exception;

    List<T> getAll();

    T getOne(Integer index) throws Exception;

    Integer getDataCount();
}
