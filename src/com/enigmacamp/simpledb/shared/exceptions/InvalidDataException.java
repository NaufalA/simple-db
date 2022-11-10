package com.enigmacamp.simpledb.shared.exceptions;

public class InvalidDataException extends Exception {
    public InvalidDataException() {
        super("Data Tidak Valid");
    }

    public InvalidDataException(String message) {
        super(message);
    }
}
