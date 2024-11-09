package Console;

import java.util.Scanner;

public class ClientConsole {

    public static void clientMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nClient Menu:");
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("0. Return to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> login(scanner, "client");
                case 2 -> registerClient(scanner);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void login(Scanner scanner, String role) {
        System.out.println("Client login logic");
        clientActions(scanner);
    }

    private static void registerClient(Scanner scanner) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           Register as Client          ");
        System.out.println("=".repeat(40));

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter ID: ");
        String id = scanner.nextLine();

        if (firstName != null && lastName != null && password != null && age > 0 && id != null) {
            System.out.println("\nClient registered successfully!");
        } else {
            System.out.println("\nRegistration unsuccessful.");
        }
    }

    private static void clientActions(Scanner scanner) {
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
                case 1 -> System.out.println("Viewing Offerings");
                case 2 -> System.out.println("Accepting Offering");
                case 3 -> System.out.println("Viewing Bookings");
                case 4 -> System.out.println("Accepting Booking");
                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
