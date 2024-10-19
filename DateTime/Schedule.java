package DateTime;
import java.util.List;
import java.util.ArrayList;

public class Schedule {
    private List<String> startDate;
    private List<String> endDate;
    private int[] daysWeek;
    private List<Time> startTime;
    private List<Time> endTime;

    public Schedule(String startDate, String endDate, String day, Time startTime, Time endTime) {
        this.startDate = new ArrayList<>();
        this.startDate.add(startDate);
        
        this.endDate = new ArrayList<>();
        this.endDate.add(endDate);
        
        this.daysWeek = new int[7];
        setDaysWeek(day);
        
        this.startTime = new ArrayList<>();
        this.startTime.add(startTime);
        
        this.endTime = new ArrayList<>();
        this.endTime.add(endTime);
        System.out.println(daysWeek.length);
    }

    public List<String> getstartDate() {
        return startDate;
    }


    public void setstartDate(List<String> startDate) {
        this.startDate = startDate;
    }


    public List<String> getendDate() {
        return endDate;
    }


    public void setendDate(List<String> endDate) {
        this.endDate = endDate;
    }


    public int[] getDaysWeek() {
        return daysWeek;
    }


    public void setDaysWeek(String day) {
        int dayIndex = convertDayToIndex(day);
        System.out.println(this.daysWeek.length);
        this.daysWeek[dayIndex]++; 
        // Increment the count for the specific day
    }
    
    // Helper method to convert day of the week to an index
    private int convertDayToIndex(String day) {
        
        switch (day.toLowerCase()) {
            case "monday": return 0;
            case "tuesday": return 1;
            case "wednesday": return 2;
            case "thursday": return 3;
            case "friday": return 4;
            case "saturday": return 5;
            case "sunday": return 6;
            default: throw new IllegalArgumentException("Invalid day of the week: " + day);
        }
    }


    public List<Time> getStartTime() {
        return startTime;
    }


    public void setStartTime(List<Time> startTime) {
        this.startTime = startTime;
    }


    public List<Time> getEndTime() {
        return endTime;
    }


    public void setEndTime(List<Time> endTime) {
        this.endTime = endTime;
    }

    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The availabilities are:\n");

        for (int i = 0; i < daysWeek.length; i++) {
            if (daysWeek[i] > 0) { // Check if the day has any availability
                String dayName = getDayName(i);
                sb.append(dayName)
                  .append(": from ")
                  .append(startTime.toString()) // Assumes Time is properly formatted
                  .append(" to ")
                  .append(endTime.toString())
                  .append(", starting from ")
                  .append(startDate) // Assuming single start date
                  .append(" until ")
                  .append(endDate) // Assuming single end date
                  .append("\n");
            }
        }

        return sb.toString();
    }

private String getDayName(int index) {
    switch (index) {
        case 0: return "Monday";
        case 1: return "Tuesday";
        case 2: return "Wednesday";
        case 3: return "Thursday";
        case 4: return "Friday";
        case 5: return "Saturday";
        case 6: return "Sunday";
        default: return "Unknown Day";
    }
}

    public static void main(String[] args) {
        Schedule one = new Schedule("09.01.2024", "11.01.2024", "Monday", new Time(5,30), new Time(7,30));
        one.setDaysWeek("Thursday");

        System.out.println(one);
    }
    

    
}
