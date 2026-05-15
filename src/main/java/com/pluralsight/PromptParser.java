package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PromptParser {
    static Scanner scanner = new Scanner(System.in);
    public static String promptForString(String prompt) {
        String result = "";
        // Keep looping until the user enters text
        while (result.trim().isEmpty()) {
            System.out.print(prompt);
            result = scanner.nextLine();


        }
        return result;
    }

    public static LocalDate promptForDate(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    public static double promptForAmount(String message) {
        //// Keep looping as long as the result is just whitespace or empty

        while (true) {
            try {
                System.out.println(message);
                String amountInput = scanner.nextLine();
                return Double.parseDouble(amountInput);

            } catch (NumberFormatException e) {
                System.err.println("Invalid selection, please type a number.");
            }
        }
    }

    public static Integer promptForInteger(String message) {
        //// Keep looping as long as the result is just whitespace or empty

        while (true) {
            try {
                System.out.println(message);
                String amountInput = scanner.nextLine();
                return Integer.parseInt(amountInput);

            } catch (NumberFormatException e) {
                System.err.println("Invalid selection, please type a number.");
            }
        }
    }

    public static LocalTime promptForTime(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return LocalTime.parse(input, DateTimeFormatter.ofPattern("HH:mm:ss"));
            } catch (DateTimeParseException e) {
                System.err.println("Invalid time format. Please use HH:mm:ss.");
            }
        }
    }

    static void pause() {
        String input = "";
        while (!input.equalsIgnoreCase("B")) {
            System.out.println();
            System.out.print("Enter B to go back: ");
            input = scanner.nextLine().trim();
        }
    }
}
