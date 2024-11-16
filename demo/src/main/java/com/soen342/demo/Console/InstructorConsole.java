package com.soen342.demo.Console;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.soen342.demo.DateTime.Schedule;
import com.soen342.demo.DateTime.Season;
import com.soen342.demo.DateTime.TimeSlot;
import com.soen342.demo.DateTime.TimeSlot.InnaccurateTimePlacement;
import com.soen342.demo.Instructor.Instructor;
import com.soen342.demo.dto.InstructorDto;
import com.soen342.demo.exception.ResourceNotFoundException;

public class InstructorConsole {
    public static int currentInstructorId;

    public static void instructorMenu(Scanner scanner, Instructor instructor) {
        while (true) {
            System.out.println("\nInstructor Menu:");
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("0. Return to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> login(scanner, instructor);
                case 2 -> registerInstructor(scanner, instructor);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void login(Scanner scanner, Instructor instructor) {
        if (instructor.instructorLogin(scanner)) {
            System.out.println("Logged in as instructor ID: " + currentInstructorId);
            instructorActions(scanner, instructor);
        }
    }

    public static void registerInstructor(Scanner scanner, Instructor instructor) {
        System.out.println("\n--- Creating a New Instructor ---");
    
        // Collect basic information
        System.out.print("Enter instructor's first name: ");
        String firstName = scanner.nextLine();
    
        System.out.print("Enter instructor's last name: ");
        String lastName = scanner.nextLine();
    
        System.out.print("Enter instructor's phone number: ");
        String phoneNumber = scanner.nextLine();
    
        // Collect cities
        System.out.print("Enter instructor's city (separate multiple cities with commas): ");
        String citiesInput = scanner.nextLine();
        List<String> cities = new ArrayList<>();
        for (String city : citiesInput.split(",")) {
            cities.add(city.trim());
        }
    
        // Collect specializations
        System.out.print("Enter instructor's specialization (separate multiple specializations with commas): ");
        String specializationsInput = scanner.nextLine();
        List<String> specializations = new ArrayList<>();
        for (String specialization : specializationsInput.split(",")) {
            specializations.add(specialization.trim());
        }
    
        // Collect password
        System.out.print("Enter instructor's password: ");
        String password = scanner.nextLine();
    
        // Collect Season details
        System.out.print("Enter season start date (YYYY-MM-DD): ");
        LocalDate seasonStartDate = LocalDate.parse(scanner.nextLine());
    
        System.out.print("Enter season end date (YYYY-MM-DD): ");
        LocalDate seasonEndDate = LocalDate.parse(scanner.nextLine());
    
        // Collect TimeSlot details
        System.out.print("Enter weekday (0 for Monday, 6 for Sunday): ");
        int weekday = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.print("Enter activity for time slot: ");
        String activity = scanner.nextLine();
    
        System.out.print("Enter start time (HH:MM): ");
        LocalTime startTime = LocalTime.parse(scanner.nextLine());
    
        System.out.print("Enter end time (HH:MM): ");
        LocalTime endTime = LocalTime.parse(scanner.nextLine());
    
        // Collect Schedule hours
        System.out.print("Enter schedule opening hours (HH:MM): ");
        LocalTime openHours = LocalTime.parse(scanner.nextLine());
    
        System.out.print("Enter schedule closing hours (HH:MM): ");
        LocalTime closeHours = LocalTime.parse(scanner.nextLine());
    
        try {
            // Create TimeSlot and Season objects
            TimeSlot timeSlot = new TimeSlot(startTime, endTime, activity);
            Season season = new Season(seasonStartDate, seasonEndDate, Season.mapDigitToDay(weekday), timeSlot);
    
            // Create Schedule object
            Schedule schedule = new Schedule(season, openHours, closeHours);
    
            // Call createInstructorDto to create the DTOs and save to DB
            instructor.createInstructorDto(timeSlot, season, phoneNumber, firstName, lastName, cities, specializations, schedule, password, weekday);
            System.out.println("Instructor has been registered");
        } catch (InnaccurateTimePlacement e) {
            System.out.println("Error in time placement: " + e.getMessage());
        }
    }


    private static void instructorActions(Scanner scanner, Instructor instructor) {
        while (true) {
            System.out.println("Instructor Actions:");
            System.out.println("1. View Available Lessons");
            System.out.println("2. Accept Lesson");
            System.out.println("0. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> instructor.viewLessons();
                case 2 -> instructor.acceptLesson(scanner, currentInstructorId);
                case 0 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
