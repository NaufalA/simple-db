package com.enigmacamp.simpledb.shared.classes;

import com.enigmacamp.simpledb.shared.utils.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class ControllerBase<T> {
    public final ServiceBase<T> service;

    public final Scanner scanner;
    public final String dbName;

    public ControllerBase(ServiceBase<T> service, Scanner scanner, String dbName) {
        this.service = service;
        this.scanner = scanner;
        this.dbName = dbName;
    }

    public void printMenu() {
        printMenuHeader(dbName);
        System.out.println("1. Add " + dbName);
        System.out.println("2. Delete " + dbName);
        System.out.println("3. View " + dbName);
        System.out.println("4. Exit");
        System.out.print("Masukkan menu yang dipilih: ");
    }

    public void printViewMenu() {
        printMenuHeader("View " + dbName);
        System.out.println("1. View by index");
        System.out.println("2. View all");
        System.out.print("Masukkan menu yang dipilih: ");
    }

    public void printMenuHeader(String title) {
        System.out.println("\n--------------------------------------\n");
        System.out.println(title);
        System.out.println("\n--------------------------------------\n");
    }

    public Integer handleMenuInput(Integer choice) {
        switch (choice) {
            case 1:
                createItemMenu();
                break;
            case 2:
                deleteItemMenu();
                break;
            case 3:
                viewItemMenu();
                break;
            case 4:
                break;
            default:
                System.out.println("Menu tidak tersedia!");
                break;
        }

        return choice;
    }

    public void createItemMenu() {
        printMenuHeader("1. Add " + dbName);
    }

    public void deleteItemMenu() {
        printMenuHeader("2. Delete " + dbName);
    }

    public void viewItemMenu() {
        printViewMenu();
    }

    public Boolean handleViewMenuInput(Integer input, Scanner scanner) {
        boolean inputInvalid;
        switch (input) {
            case 1:
                printMenuHeader("View By Index");
                System.out.print("Masukkan index yang ingin ditampilkan: ");
                viewByIndex(InputValidator.handleIntegerInput(scanner, true));
                inputInvalid = false;
                break;
            case 2:
                viewAll();
                inputInvalid = false;
                break;
            default:
                System.out.println("Menu tidak tersedia!");
                inputInvalid = true;
                break;
        }

        return inputInvalid;
    }

    public void viewByIndex(Integer index) {
        try {
            T item = service.getOne(index);
            System.out.println(index + ".");
            printItem(item);
            System.out.println("\n--------------------------------------\n");
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public void viewAll() {
        printMenuHeader("View By All");
        ArrayList<T> items = service.getAllItem();
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ".");
            printItem(items.get(i));
        }
    }

    public void printItem(T item) {}

}
