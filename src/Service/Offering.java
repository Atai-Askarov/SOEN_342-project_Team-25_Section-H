package Service;

import DateTime.TimeSlot;
import Location.Location;
import Instructor.Instructor;

public class Offering extends Lesson {
    private Instructor instructor;

    public Offering() {
        super();
    }

    public Offering(Lesson lesson, Instructor instructor) {
        super(
                lesson.getTimeSlot(),
                lesson.getLocation(),
                lesson.getMode(),
                lesson.getStatus(),
                lesson.getCapacity(),
                lesson.getLessonName());
        this.instructor = instructor;
    }

    public Offering(TimeSlot timeSlot, Location location, String mode, String status, int capacity, String lessonName,
            Instructor instructor) {
        super(timeSlot, location, mode, status, capacity, lessonName);
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
