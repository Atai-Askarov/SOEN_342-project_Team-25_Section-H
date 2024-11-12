package com.soen342.demo.Console;

import java.util.Scanner;

public class InstructorConsole {

    public static void instructorMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nInstructor Menu:");
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("0. Return to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> login(scanner, "instructor");
                case 2 -> registerInstructor(scanner);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void login(Scanner scanner, String role) {
        // Login logic
        System.out.println("Instructor login logic here...");
        instructorActions(scanner);
    }

    private static void registerInstructor(Scanner scanner) {
        System.out.println("Registering instructor...");

    }

    private static void instructorActions(Scanner scanner) {
        while (true) {
            System.out.println("Instructor Actions:");
            System.out.println("1. View Available Offerings");
            System.out.println("2. Accept Offerings");
            System.out.println("0. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> System.out.println("Viewing Available Offerings...");
                case 2 -> System.out.println("Accepting Offerings...");
                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
