package com.soen342.demo.Instructor;

import java.util.ArrayList;

import com.soen342.demo.Console.InstructorConsole;
import com.soen342.demo.DateTime.*;
import com.soen342.demo.Location.Location;
import com.soen342.demo.Service.*;
import com.soen342.demo.ServiceInterfaces.InstructorService;
import com.soen342.demo.ServiceInterfaces.OfferingService;
import com.soen342.demo.ServiceInterfaces.ScheduleService;
import com.soen342.demo.ServiceInterfaces.SeasonService;
import com.soen342.demo.ServiceInterfaces.TimeSlotService;
import com.soen342.demo.ServiceInterfaces.LessonService;
import com.soen342.demo.ServiceInterfaces.LocationService;
import com.soen342.demo.dto.InstructorDto;
import com.soen342.demo.dto.LessonDto;
import com.soen342.demo.dto.LocationDto;
import com.soen342.demo.dto.OfferingDto;
import com.soen342.demo.dto.ScheduleDto;
import com.soen342.demo.dto.SeasonDto;
import com.soen342.demo.dto.TimeSlotDto;
import com.soen342.demo.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Instructor {
    private String phone_number;
    private String first_name;
    private String last_name;
    private List<String> city;
    private List<String> specialization;
    private Schedule availability;
    private String password;

    private final TimeSlotService timeSlotService;
    private final SeasonService seasonService;
    private final ScheduleService scheduleService;
    private final InstructorService instructorService;
    private final OfferingService offeringService;
    private final LessonService lessonService;
    private final LocationService locationService;

    @Autowired
    public Instructor(TimeSlotService timeSlotService, LocationService locationService, SeasonService seasonService, ScheduleService scheduleService, InstructorService instructorService, OfferingService offeringService, LessonService lessonService) {
        this.timeSlotService = timeSlotService;
        this.seasonService = seasonService;
        this.scheduleService = scheduleService;
        this.instructorService = instructorService;
        this.offeringService = offeringService;
        this.lessonService = lessonService;
        this.locationService = locationService;
    }

    public Instructor(){
        this.timeSlotService = null;
        this.seasonService = null;
        this.scheduleService = null;
        this.instructorService = null;
        this.offeringService = null;
        this.lessonService = null;
        this.locationService = null;
    }

    public Instructor(String phone_number, String first_name, String last_name, List<String> city, List<String> specialization, Schedule availability, String password) {
        this.phone_number = phone_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.city = city;
        this.specialization = specialization;
        this.availability = availability;
        this.password = password;
        this.timeSlotService = null;
        this.seasonService = null;
        this.scheduleService = null;
        this.instructorService = null;
        this.offeringService = null;
        this.lessonService = null;
        this.locationService = null;
    }

    

    // Getters and Setters
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }

    public List<String> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<String> specialization) {
        this.specialization = specialization;
    }

    public Schedule getAvailability() {
        return availability;
    }

    public void setAvailability(Schedule availability) {
        this.availability = availability;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(10000); // Generates a random integer between 0 and 9999
    }

    public void ViewLessons() {
        List<LessonDto> lessons = lessonService.getAllLessons();
        for (LessonDto lesson : lessons) {
            System.out.println(lesson.getLessonName());
        }
    }
    

    public void acceptLesson(Scanner scanner, int instructorId) {
        System.out.print("Enter the Lesson ID you want to accept: ");
        int lessonId = scanner.nextInt();
        scanner.nextLine();
    
        LessonDto lessonDto = lessonService.getLessonById(lessonId);
    
        if (lessonDto == null) {
            System.out.println("Lesson not found with ID: " + lessonId);
            return;
        }
    
        System.out.println("Found Lesson: " + lessonDto.getLessonName());
        System.out.println("Capacity: " + lessonDto.getCapacity());
        System.out.println("Mode: " + lessonDto.getMode());
        System.out.println("Status: " + lessonDto.getStatus());
    
        if (!"available".equalsIgnoreCase(lessonDto.getStatus())) {
            System.out.println("Lesson is not available and cannot be accepted.");
            return;
        }
    
        System.out.print("Do you want to accept this lesson? (yes/no): ");
        String choice = scanner.nextLine().toLowerCase();
    
        if (!choice.equals("yes")) {
            System.out.println("You chose not to accept the lesson.");
            return;
        }
    
        // Generate Offering ID
        int OfferingIdGenerated = generateRandomId();
        OfferingDto offeringDto = new OfferingDto();
    

        if (lessonDto.getCapacity() > 0) {
            // Update capacity and create the offering
            lessonDto.setCapacity(lessonDto.getCapacity() - 1);
            offeringDto.setInstructorId(instructorId);
            offeringDto.setLessonId(lessonDto.getLessonId());
            offeringDto.setOfferingId(OfferingIdGenerated);
    
            offeringService.createOffering(offeringDto);
            System.out.println("You have successfully accepted the lesson!");
        } else {
            System.out.println("Lesson is full and cannot be accepted.");
        }
    }
    

    public void createInstructorDto(TimeSlot timeSlot, Season season, String phoneNumber, String firstName, String lastName, List<String> cities, List<String> specializations, Schedule schedule, String password, int weekday) {
        TimeSlotDto timeSlotDto = new TimeSlotDto();
        timeSlotDto.setTimeslot_id(generateRandomId());
        timeSlotDto.setWeekday(weekday);
        timeSlotDto.setStart_time(timeSlot.getStart());
        timeSlotDto.setEnd_time(timeSlot.getEnd());
        timeSlotDto.setActivity(timeSlot.getActivity());
        timeSlotService.createTimeSlot(timeSlotDto);
    
        SeasonDto seasonDto = new SeasonDto();
        seasonDto.setSeason_id(generateRandomId());
        seasonDto.setStart_date(season.getStartDate());
        seasonDto.setEnd_date(season.getEndDate());
        seasonDto.setTimeslot_id(timeSlotDto.getTimeslot_id());
        seasonService.createSeason(seasonDto);
    
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setSchedule_id(generateRandomId());
        scheduleDto.setSeason_id(seasonDto.getSeason_id());
        scheduleDto.setOwner_id(generateRandomId());
        scheduleService.createSchedule(scheduleDto);
    
        InstructorDto instructorDto = new InstructorDto();
        instructorDto.setInstructor_id(scheduleDto.getOwner_id());
        instructorDto.setFirst_name(firstName);
        instructorDto.setLast_name(lastName);
        instructorDto.setPhone_number(phoneNumber);
        instructorDto.setCity(String.join(", ", cities));
        instructorDto.setSpecialization_name(String.join(", ", specializations));
        instructorDto.setPassword(password);
        instructorDto.setSchedule_id(scheduleDto.getSchedule_id());
        instructorDto.setSeason_id(seasonDto.getSeason_id());
    

        instructorService.createInstructor(instructorDto);
    }

    public boolean instructorLogin(Scanner scanner){
        System.out.println("Instructor Login:");

        // Collect phone number and password
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check instructor credentials against the database
        try {
            InstructorDto instructorDto = instructorService.getInstructorbyPhoneNumber(phoneNumber);

            if (instructorDto.getPassword().equals(password)) {
                System.out.println("Login successful!");
                InstructorConsole.currentInstructorId = instructorDto.getInstructor_id();
                return true;  // Proceed to instructor actions
            } else {
                System.out.println("Invalid password. Please try again.");
                return false;
            }
        } catch (ResourceNotFoundException e) {
            System.out.println("Instructor not found with the given phone number.");
        }

        return false;
    }

    public void viewLessons() {
        List<LessonDto> lessons = lessonService.getAllLessons();
        if (lessons.isEmpty()) {
            System.out.println("No lessons found.");
        } else {
            System.out.println("\n--- Lessons ---");
            for (LessonDto lesson : lessons) {
                System.out.println("Lesson ID: " + lesson.getLessonId());
                System.out.println("Lesson Name: " + lesson.getLessonName());
                System.out.println("Mode: " + lesson.getMode());
                System.out.println("Status: " + lesson.getStatus());
                System.out.println("Capacity: " + lesson.getCapacity());
                System.out.println("Location ID: " + lesson.getLocationId());
                System.out.println("Timeslot ID: " + lesson.getTimeslotId());
                System.out.println("-".repeat(30));
            }
        }
    }
}
