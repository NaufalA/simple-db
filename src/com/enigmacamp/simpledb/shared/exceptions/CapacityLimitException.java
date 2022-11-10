package com.enigmacamp.simpledb.shared.exceptions;

public class CapacityLimitException extends Exception {
    public CapacityLimitException() {
        super("Database Sudah Penuh");
    }

    public CapacityLimitException(String message) {
        super(message);
    }
}
