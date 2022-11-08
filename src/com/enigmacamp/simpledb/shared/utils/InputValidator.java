package com.enigmacamp.simpledb.shared.utils;

import java.util.Scanner;

public class InputValidator {
    public static Integer handleIntegerInput(Scanner scanner, boolean shouldLoop) {
        boolean inputValid;
        int parsedInput = 0;
        do {
            try {
                parsedInput = Integer.parseInt(scanner.nextLine());
                inputValid = true;
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                inputValid = !shouldLoop;
            }
        }
        while (!inputValid);
        return parsedInput;
    }
}
