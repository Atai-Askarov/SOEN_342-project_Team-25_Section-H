package com.soen342.demo.Console;

import java.util.Scanner;

public class AdminConsole {

    public static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n\n" + "-".repeat(40));
            System.out.println("Admin Menu:");
            System.out.println("1. Log In");
            System.out.println("0. Return to Main Menu");
            System.out.println("-".repeat(40));
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> login(scanner);
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.println("Admin login logic");
        adminActions(scanner);
    }

    private static void adminActions(Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Actions:");
            System.out.println("1. Access Offering Catalog");
            System.out.println("2. Access Instructor Database");
            System.out.println("3. Access Client Database");
            System.out.println("4. Access Booking Database");
            System.out.println("0. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> AdminOfferingCatalogActions(scanner);
                case 2 -> AdminInstructorCatalogActions(scanner);
                case 3 -> AdminClientCatalogActions(scanner);
                case 4 -> AdminBookingCatalogActions(scanner);
                case 0 -> {
                    System.out.println("\nLogging out...");
                    return;
                }
                default -> System.out.println("\nInvalid option. Try again.");
            }
        }
    }

    private static void AdminOfferingCatalogActions(Scanner scanner) {
        while (true) {
            System.out.println("\nOffering Catalog Actions:");
            System.out.println("1. View Offerings");
            System.out.println("2. Add Offering");
            System.out.println("3. Modify Offering");
            System.out.println("4. Delete Offering");
            System.out.println("0. Return to Admin Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Viewing all offerings");
                case 2 -> System.out.println("Adding a new offering");
                case 3 -> System.out.println("Modifying an offering");
                case 4 -> System.out.println("Deleting an offering");
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void AdminInstructorCatalogActions(Scanner scanner) {
        while (true) {
            System.out.println("\nInstructor Database Actions:");
            System.out.println("1. View Instructors");
            System.out.println("2. Delete Instructor Account");
            System.out.println("0. Return to Admin Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Viewing all instructor accounts");
                case 2 -> System.out.println("Deleting an instructor account");
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void AdminClientCatalogActions(Scanner scanner) {
        while (true) {
            System.out.println("\nClient Database Actions:");
            System.out.println("1. View Clients");
            System.out.println("2. Delete Client Account");
            System.out.println("0. Return to Admin Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Viewing all client accounts");
                case 2 -> System.out.println("Deleting a client account");
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void AdminBookingCatalogActions(Scanner scanner) {
        while (true) {
            System.out.println("\nBooking Database Actions:");
            System.out.println("1. View Bookings");
            System.out.println("2. Add Booking");
            System.out.println("3. Modify Booking");
            System.out.println("4. Delete Booking");
            System.out.println("0. Return to Admin Menu");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Viewing all bookings");
                case 2 -> System.out.println("Adding a new booking");
                case 3 -> System.out.println("Modifying a booking");
                case 4 -> System.out.println("Deleting a booking");
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }
}
