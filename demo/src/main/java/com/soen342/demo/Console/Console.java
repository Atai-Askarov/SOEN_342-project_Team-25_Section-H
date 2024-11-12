package com.soen342.demo.Console;

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
                case 1 -> AdminConsole.adminMenu(scanner);
                case 2 -> InstructorConsole.instructorMenu(scanner);
                case 3 -> ClientConsole.clientMenu(scanner);
                case 0 -> {
                    System.out.println("\nThank you for using the LessonBooker. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }
}
