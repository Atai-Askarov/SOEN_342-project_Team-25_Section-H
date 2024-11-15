package com.soen342.demo;

import com.soen342.demo.ServiceInterfaces.LessonService;
import com.soen342.demo.dto.LessonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class backendApplication implements CommandLineRunner {

    @Autowired
    private LessonService lessonService;

    public static void main(String[] args) {
        SpringApplication.run(backendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createSampleLesson();  // Call the method to create a sample lesson
    }

    public void createSampleLesson() {
        // Create a LessonDto object with sample data
        LessonDto lessonDto = new LessonDto();
        lessonDto.setLessonId(3);  // Let the database auto-generate this value
        lessonDto.setLocationId(101);
        lessonDto.setTimeslotId(202);
        lessonDto.setMode("Online");
        lessonDto.setStatus("Active");
        lessonDto.setCapacity(30);
        lessonDto.setLessonName("Software Engineering 101");

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
