package com.enigmacamp.simpledb.shared.interfaces;

public interface Controller<T> {
    Boolean run();

    void printMenu();

    void printViewMenu();

    void printMenuHeader(String title);

    Integer handleMenuInput(Integer choice);

    void createItemMenu();

    void deleteItemMenu();

    void viewItemMenu();

    Boolean handleViewMenuInput(Integer input);

    void viewByIndex(Integer index);

    void viewAll();
}
