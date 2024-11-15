package com.soen342.demo.Admin;

import com.soen342.demo.DateTime.Schedule;
import com.soen342.demo.DateTime.Season;
import com.soen342.demo.DateTime.TimeSlot;
import com.soen342.demo.DateTime.TimeSlot.InnaccurateTimePlacement;
import com.soen342.demo.Location.Location;
import com.soen342.demo.ServiceInterfaces.*;
import com.soen342.demo.dto.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Admin {

    private final LessonService lessonService;
    private final TimeSlotService timeSlotService;
    private final ScheduleService scheduleService;
    private final SeasonService seasonService;
    private final LocationService locationService;

    @Autowired
    public Admin(LessonService lessonService, TimeSlotService timeSlotService, ScheduleService scheduleService, SeasonService seasonService, LocationService locationService) {
        this.lessonService = lessonService;
        this.timeSlotService = timeSlotService;
        this.scheduleService = scheduleService;
        this.seasonService = seasonService;
        this.locationService = locationService;
    }

    public void createLesson() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Creating a New Lesson ---");

        System.out.print("Enter lesson name: ");
        String lessonName = scanner.nextLine();

        System.out.print("Enter mode (e.g., private, group): ");
        String mode = scanner.nextLine();

        System.out.print("Enter status (e.g., available, unavailable): ");
        String status = scanner.nextLine();

        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter weekday (e.g., 0 for Monday, 6 for Sunday): ");
        int weekday = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter activity for time slot: ");
        String activity = scanner.nextLine();

        System.out.print("Enter start time (HH:MM): ");
        LocalTime startTime = LocalTime.parse(scanner.nextLine());

        System.out.print("Enter end time (HH:MM): ");
        LocalTime endTime = LocalTime.parse(scanner.nextLine());

        System.out.print("Enter season start date (YYYY-MM-DD): ");
        LocalDate seasonStartDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter season end date (YYYY-MM-DD): ");
        LocalDate seasonEndDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter schedule opening hours (HH:MM): ");
        LocalTime openHours = LocalTime.parse(scanner.nextLine());

        System.out.print("Enter schedule closing hours (HH:MM): ");
        LocalTime closeHours = LocalTime.parse(scanner.nextLine());

        System.out.print("Enter location name: ");
        String locationName = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        try {
            // Creating objects from the input data
            TimeSlot timeSlot = new TimeSlot(startTime, endTime, activity);
            Season season = new Season(seasonStartDate, seasonEndDate, Season.mapDigitToDay(weekday), timeSlot);
            Schedule schedule = new Schedule(season, openHours, closeHours);
            Location location = new Location(locationName, schedule, address, city);

            // Call createLesson to save the lesson
            createLessonToDB(timeSlot, location, season, schedule, mode, status, capacity, weekday, lessonName);

        } catch (InnaccurateTimePlacement e) {
            System.out.println("Error in time placement: " + e.getMessage());
        }
    }

    public void createLessonToDB(TimeSlot timeSlot, Location location, Season season, Schedule schedule, String mode, String status, int capacity, int weekday, String lessonName) {
        long timestamp = System.currentTimeMillis();
        int randomNum = (int) (Math.random() * 1000) + (int)timestamp;
        
        //Create time slot item of lesson
        TimeSlotDto timeSlotDto = new TimeSlotDto();
        timeSlotDto.setTimeslot_id(randomNum);
        timeSlotDto.setActivity(timeSlot.getActivity());
        timeSlotDto.setStart_time(timeSlot.getStart());
        timeSlotDto.setEnd_time(timeSlot.getEnd());
        timeSlotDto.setWeekday(weekday);

        TimeSlotDto savedTimeSlot = timeSlotService.createTimeSlot(timeSlotDto);

        //Create season aspect
        SeasonDto seasonDto = new SeasonDto();
        seasonDto.setSeason_id(randomNum);
        seasonDto.setStart_date(season.getStartDate());
        seasonDto.setEnd_date(season.getEndDate());
        seasonDto.setTimeslot_id(savedTimeSlot.getTimeslot_id());

        SeasonDto savedSeason = seasonService.createSeason(seasonDto);

        // create schedule aspect
        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setSchedule_id(randomNum);
        scheduleDto.setOpening_hours(schedule.getOpenHours());
        scheduleDto.setClosing_hours(schedule.getCloseHours());
        scheduleDto.setSeason_id(savedSeason.getSeason_id());

        ScheduleDto savedSchedule = scheduleService.createSchedule(scheduleDto);

        //create location
        LocationDto locationDto = new LocationDto();
        locationDto.setLocation_id(randomNum);
        locationDto.setAddress(location.getAddress());
        locationDto.setCity(location.getCity());
        locationDto.setLocation_name(location.getName());
        locationDto.setSchedule_id(savedSchedule.getSchedule_id());
        locationDto.setSeason_id(savedSeason.getSeason_id());

        LocationDto savedLocation = locationService.createLocation(locationDto);

        // Create a LessonDto object with sample data
        LessonDto lessonDto = new LessonDto();
        lessonDto.setLocationId(randomNum);
        lessonDto.setLocationId(savedLocation.getLocation_id());
        lessonDto.setTimeslotId(savedTimeSlot.getTimeslot_id());
        lessonDto.setMode(mode);
        lessonDto.setStatus(status);
        lessonDto.setCapacity(capacity);
        lessonDto.setLessonName(lessonName);

        // Call the LessonService to create the lesson in the database
        LessonDto savedLesson = lessonService.createLesson(lessonDto);

        // Print the saved lesson's details
        System.out.println("Lesson saved successfully: ");
        System.out.println("Lesson ID: " + savedLesson.getLessonId());
        System.out.println("Location ID: " + savedLesson.getLocationId());
        System.out.println("Timeslot ID: " + savedLesson.getTimeslotId());
        System.out.println("Mode: " + savedLesson.getMode());
        System.out.println("Status: " + savedLesson.getStatus());
        System.out.println("Capacity: " + savedLesson.getCapacity());
        System.out.println("Lesson Name: " + savedLesson.getLessonName());
    }
}
