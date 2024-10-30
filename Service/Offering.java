package Service;
import DateTime.Schedule;

import Location.Location;

public class Offering {
    private Schedule timeslot; // a short timeframe over which the lesson is given. Spans over the duration of a week.
    private String mode;
    private String status;
    private int capacity;
    private Location location;
    private String lession;
}
