package DateTime;

import java.time.LocalTime;

public class TimeSlot implements Comparable<TimeSlot> {
    private LocalTime start;
    private LocalTime end;
    private String activity;

    public TimeSlot(LocalTime value, Boolean openHours) {
        // this lets set the opening/ closing hours for provided by the schedule class
        if (openHours)
            this.start = value;
        else
            this.end = value;
    }

    public TimeSlot(LocalTime start, LocalTime end) throws InnaccurateTimePlacement {
        this.start = start;
        this.end = end;
        if (start.isAfter(end))
            throw new InnaccurateTimePlacement();
    }

    public TimeSlot(LocalTime start, LocalTime end, String activity) throws InnaccurateTimePlacement {
        this.start = start;
        this.end = end;
        this.activity = activity;
        if (start.isAfter(end))
            throw new InnaccurateTimePlacement();
    }

    public class InnaccurateTimePlacement extends Exception {
        public InnaccurateTimePlacement(String message) {
            super(message);
        }

        public InnaccurateTimePlacement() {
            super("the Start time must be before the end time");
        }
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) throws InnaccurateTimePlacement {
        this.start = start;
        if (this.end != null) {
            if (start.isAfter(this.end)) {
                throw new InnaccurateTimePlacement();
            }
        }
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) throws InnaccurateTimePlacement {
        this.end = end;
        if (this.start != null) {
            if (end.isBefore(this.start)) {
                throw new InnaccurateTimePlacement();
            }
        }
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int compareTo(TimeSlot other) {
        // First compare by start time
        int startComparison = this.start.compareTo(other.start);
        return startComparison; // Return the result of the start time comparison
    }

    public Boolean isWithinTimeSlot(TimeSlot other) {
        return (other.getStart().compareTo(this.start) >= 0 && other.getEnd().compareTo(this.end) <= 0);

    }

    @Override
    public String toString() {
        if (activity != null)
            return activity + " starts at " + start + " and ends at " + end;
        else
            return "this event starts at " + start + " and ends at " + end;
    }

}
