package com.soen342.demo.Console;

import com.soen342.demo.Admin.Admin;

import java.util.Scanner;

public class AdminConsole {

    public static void adminMenu(Scanner scanner, Admin admin) {
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
                case 1 -> login(scanner, admin);
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void login(Scanner scanner, Admin admin) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if the username and password are both "admin"
        if ("admin".equals(username) && "admin".equals(password)) {
            System.out.println("Login successful!");
            adminActions(scanner, admin);
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void adminActions(Scanner scanner, Admin admin) {
        while (true) {
            System.out.println("\nAdmin Actions:");
            System.out.println("1. Create Lesson");
            System.out.println("2. View Lessons");
            System.out.println("3. Delete Lesson");
            System.out.println("4. View Client Accounts");
            System.out.println("5. Delete Client Account");
            System.out.println("6. View Instructor Accounts");
            System.out.println("7. Delete Instructor Account");
            System.out.println("8. View All Bookings");
            System.out.println("9. Delete Booking");
            System.out.println("10. View All Offerings");
            System.out.println("11. Delete Offering");
            System.out.println("0. Logout");
    
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1 -> admin.createLesson(scanner);
                case 2 -> admin.viewLessons();
                case 3 -> admin.deleteLesson(scanner);
                case 4 -> admin.viewClients();
                case 5 -> admin.deleteClientById(scanner);
                case 6 -> admin.viewInstructors();
                case 7 -> admin.deleteInstructorById(scanner);
                case 8 -> admin.viewAllBookings();
                case 9 -> admin.deleteBookingById(scanner);
                case 10 -> admin.viewAllOfferings();
                case 11 -> admin.deleteOfferingById(scanner);
                case 0 -> {
                    System.out.println("\nLogging out...");
                    return;
                }
                default -> System.out.println("\nInvalid option. Try again.");
            }
        }
    }
}
