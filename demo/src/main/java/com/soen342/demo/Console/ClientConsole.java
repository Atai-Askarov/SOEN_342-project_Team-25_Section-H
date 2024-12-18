package com.soen342.demo.Console;

import java.util.Scanner;

import com.soen342.demo.Client.Client;

public class ClientConsole {
    public static int currentClientId;

    public static void clientMenu(Scanner scanner, Client client) {
        while (true) {
            System.out.println("\nClient Menu:");
            System.out.println("1. Log In");
            System.out.println("2. View Offerings");
            System.out.println("3. Register");
            System.out.println("0. Return to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> login(scanner, client);
                case 2 -> client.viewAllOfferings();
                case 3 -> registerClient(scanner, client);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void login(Scanner scanner, Client client) {
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (client.login(phoneNumber, password)) {
            clientActions(scanner, client);
        }
    }

    private static void registerClient(Scanner scanner, Client client) {
        System.out.println("\nRegister as Client");

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (age < 18) {
            System.out.println("Client is underage please go through a parent guardian account to use the system.");
            return;
        }

        System.out.print("Child under supervision (write no if you are not booking for a child): ");
        String guardianPhoneNumber = scanner.nextLine();

        if (firstName != null && lastName != null && password != null && age > 0 && phoneNumber != null) {
            client.createClientToDB(age, firstName, lastName, phoneNumber, password, guardianPhoneNumber);
            System.out.println("\nClient registered successfully!");
        } else {
            System.out.println("\nRegistration unsuccessful.");
        }
    }

    private static void clientActions(Scanner scanner, Client client) {
        while (true) {
            System.out.println("Client Actions:");
            System.out.println("1. View Offerings");
            System.out.println("2. Accept Offering");
            System.out.println("3. View Bookings");
            System.out.println("4. Cancel Booking");
            System.out.println("0. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> client.viewAllOfferings();
                case 2 -> client.acceptOffering(scanner, currentClientId);
                case 3 -> client.viewOwnBookings(currentClientId);
                case 4 -> client.cancelBooking(scanner);
                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
