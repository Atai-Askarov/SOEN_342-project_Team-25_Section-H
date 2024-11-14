package com.soen342.demo.Service;

import com.soen342.demo.DateTime.TimeSlot;
import com.soen342.demo.Location.Location;
import com.soen342.demo.Instructor.Instructor;
import com.soen342.demo.Client.Client;

public class Booking extends Offering {
    private Client client;
    private boolean availability;

    public Booking() {
        super();
    }
    
    public Booking(TimeSlot timeSlot, Location location, String mode, String status, int capacity, String lessonName,
            Instructor instructor, Client client, boolean availability) {
        super(timeSlot, location, mode, status, capacity, lessonName, instructor);
        this.client = client;
        this.availability = availability;
    }
    public Booking(Offering offering, Client client, boolean availability) {
        super(
                offering.getTimeSlot(),
                offering.getLocation(),
                offering.getMode(),
                offering.getStatus(),
                offering.getCapacity(),
                offering.getLessonName(),
                offering.getInstructor());
        this.client = client;
        this.availability = availability;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}