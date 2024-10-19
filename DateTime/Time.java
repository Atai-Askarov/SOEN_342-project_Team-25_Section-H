package DateTime;


public class Time {
    private int hours;
    private int minutes;

    // Constructor to initialize time in 24-hour format
    public Time(int hours, int minutes) {
        setTime(hours, minutes);
    }

    // Constructor to initialize time in 12-hour format (with AM/PM)
    public Time(int hours, int minutes, String period) {
        if (period.equalsIgnoreCase("AM") || period.equalsIgnoreCase("PM")) {
            if (hours == 12) {
                this.hours = (period.equalsIgnoreCase("AM")) ? 0 : 12;
            } else {
                this.hours = (period.equalsIgnoreCase("AM")) ? hours : hours + 12;
            }
        } else {
            throw new IllegalArgumentException("Invalid period! Use AM or PM.");
        }
        setMinutes(minutes);
    }

    // Set the time (validates the input for 24-hour format)
    public void setTime(int hours, int minutes) {
        if (hours >= 0 && hours < 24) {
            this.hours = hours;
        } else {
            throw new IllegalArgumentException("Invalid hours!");
        }
        setMinutes(minutes);
    }

    // Set minutes with validation
    private void setMinutes(int minutes) {
        if (minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        } else {
            throw new IllegalArgumentException("Invalid minutes!");
        }
    }

    // Method to display time in 12-hour format with AM/PM
    public String toString() {
        String period = hours < 12 ? "AM" : "PM";
        int displayHours = (hours == 0 || hours == 12) ? 12 : hours % 12;
        return String.format("%02d:%02d %s", displayHours, minutes, period);
    }


    // Getter methods for hours and minutes
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }
}

