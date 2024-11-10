package Service;

import DateTime.TimeSlot;
import Location.Location;

public class Lesson {
    private TimeSlot timeSlot;
    private Location location;
    private String mode;
    private String status;
    private int capacity;
    private String lessonName;

    public Lesson() {
    }

    public Lesson(TimeSlot timeSlot, Location location, String mode, String status, int capacity, String lessonName) {
        this.timeSlot = timeSlot;
        this.location = location;
        this.mode = mode;
        this.status = status;
        this.capacity = capacity;
        this.lessonName = lessonName;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
