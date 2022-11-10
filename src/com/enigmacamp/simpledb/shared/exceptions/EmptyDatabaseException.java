package com.enigmacamp.simpledb.shared.exceptions;

public class EmptyDatabaseException extends Exception {
    public EmptyDatabaseException() {
        super("Database Kosong");
    }

    public EmptyDatabaseException(String message) {
        super(message);
    }
}
