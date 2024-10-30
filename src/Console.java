package src;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=".repeat(40));
        System.out.println("      Welcome to the LessonBooker     ");
        System.out.println("=".repeat(40));

        while (true) {
            System.out.println("\n" + "-".repeat(40));
            System.out.println("Main Menu:");
            System.out.println("Please choose the option that applies:");
            System.out.println("1. Administrator");
            System.out.println("2. Instructor");
            System.out.println("3. Client");
            System.out.println("0. Exit");
            System.out.println("-".repeat(40));
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> adminMenu();
                case 2 -> instructorMenu();
                case 3 -> clientMenu();
                case 0 -> {
                    System.out.println("\nThank you for using the LessonBooker. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void adminMenu() {
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
                case 1 -> login("admin");
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void instructorMenu() {
        while (true) {
            System.out.println("\n\n" + "-".repeat(40));
            System.out.println("Instructor Menu:");
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("0. Return to Main Menu");
            System.out.println("-".repeat(40));
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> login("instructor");
                case 2 -> registerInstructor();
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void clientMenu() {
        while (true) {
            System.out.println("\n\n" + "-".repeat(40));
            System.out.println("Client Menu:");
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("0. Return to Main Menu");
            System.out.println("-".repeat(40));
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> login("client");
                case 2 -> registerClient();
                case 0 -> {
                    return;
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void login(String role) {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("                Login Portal                ");
        System.out.println("=".repeat(40));

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = new User(username, password, role);
        if (username.equals("admin") && password.equals("admin123")) {
            {
                System.out.println("\nLogin successful!");

                if (role.equals("admin")) {
                    adminActions();
                } else if (role.equals("instructor")) {
                    instructorActions(user);
                } else {
                    clientActions(user);
                }
            }
        } else {
            System.out.println("\nInvalid credentials or role mismatch. Please try again.");
        }
    }

    private static void registerInstructor() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           Register as Instructor          ");
        System.out.println("=".repeat(40));

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter availability city: ");
        String city = scanner.nextLine();

        if (username != null && password != null && phone != null && specialization != null && city != null) {
            System.out.println("\nInstructor registered successfully!");
        } else {
            System.out.println("\nRegistration unsuccessfull.");
        }
    }

    private static void registerClient() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           Register as Client          ");
        System.out.println("=".repeat(40));

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username != null && password != null) {
            System.out.println("\nClient registered successfully!");
        } else {
            System.out.println("\nUsername already taken. Please try another one.");
        }
    }

    private static void adminActions() {
        while (true) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("Admin Actions:");
            System.out.println("1. View Lessons Catalog");
            System.out.println("2. View Instructor Database");
            System.out.println("3. View Client Database");
            System.out.println("4. View Schedule Database");
            System.out.println("0. Logout");
            System.out.println("-".repeat(40));
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("\nnot implemented");
                case 2 -> System.out.println("\nnot implemented");
                case 3 -> System.out.println("\nnot implemented");
                case 4 -> System.out.println("\nnot implemented");
                case 0 -> {
                    System.out.println("\nLogging out...");
                    return;
                }
                default -> System.out.println("\nInvalid option. Try again.");
            }
        }
    }

    private static void instructorActions(User user) {
        while (true) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("Instructor Actions:");
            System.out.println("1. View Available Offerings");
            System.out.println("2. Accept Offerings");
            System.out.println("0. Logout");
            System.out.println("-".repeat(40));
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("\nAvailable Offerings: ");
                case 2 -> System.out.println("\nNot implemented yet");
                case 0 -> {
                    System.out.println("\nLogging out...");
                    return;
                }
                default -> System.out.println("\nInvalid option. Try again.");
            }
        }
    }

    private static void clientActions(User user) {
        while (true) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("Client Actions:");
            System.out.println("1. View Offerings");
            System.out.println("2. Accept Offering");
            System.out.println("0. Logout");
            System.out.println("-".repeat(40));
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("\nAvailable Offerings: ");
                case 2 -> System.out.println("\nNot implemented yet");
                case 0 -> {
                    System.out.println("\nLogging out...");
                    return;
                }
                default -> System.out.println("\nInvalid option. Try again.");
            }
        }
    }

    // Inner User class to handle roles and profiles
    private static class User {
        private String username;
        private String password;
        private String role;

        public User(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }
    }
}