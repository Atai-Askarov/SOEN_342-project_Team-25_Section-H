package DateTime;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalTime; 

public class Season {
    private LocalDate startDate;
    private LocalDate endDate;
    private int[] daysWeek = new int[7];
    private List<LocalTime> startTime;
    private List<LocalTime> endTime;

    public boolean equals(Object obj) {
        // Check if the object is compared with itself
        if (this == obj) {
            return true;
        }

        // Check if the object is an instance of YourClass
        if (!(obj instanceof Season)) {
            return false;
        }

        // Cast the object to YourClass
        Season other = (Season) obj;

        // Compare startDate
        if (startDate != null ? !startDate.equals(other.startDate) : other.startDate != null) {
            return false;
        }

        // Compare endDate
        if (endDate != null ? !endDate.equals(other.endDate) : other.endDate != null) {
            return false;
        }

        // Compare daysWeek
        if (!Arrays.equals(daysWeek, other.daysWeek)) {
            return false;
        }

        // Compare startTime
        if (startTime != null ? !startTime.equals(other.startTime) : other.startTime != null) {
            return false;
        }

        // Compare endTime
        return endTime != null ? endTime.equals(other.endTime) : other.endTime == null;
    }

    @Override
    public int hashCode() {
        int result = (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(daysWeek);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

    public Season(){

    }
    public Season(LocalDate startDate, LocalDate endDate, int[] daysWeek, List<LocalTime> startTime,
            List<LocalTime> endTime) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.daysWeek = daysWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    static String mapDigitToDay(int digit) {
        String day;
        switch (digit) {
            case 0:
                day = "Monday";
                break;
            case 1:
                day = "Tuesday";
                break;
            case 2:
                day = "Wednesday";
                break;
            case 3:
                day = "Thursday";
                break;
            case 4:
                day = "Friday";
                break;
            case 5:
                day = "Saturday";
                break;
            case 6:
                day = "Sunday";
                break;
            default:
                throw new IllegalArgumentException("Invalid digit: " + digit);
        }
        return day;
    }
    

    static int mapDayToDigit(String day) {
        int digit;
        switch (day.toLowerCase()) {
            case "monday":
                digit = 0;
                break;
            case "tuesday":
                digit = 1;
                break;
            case "wednesday":
                digit = 2;
                break;
            case "thursday":
                digit = 3;
                break;
            case "friday":
                digit = 4;
                break;
            case "saturday":
                digit = 5;
                break;
            case "sunday":
                digit = 6;
                break;
            default:
                throw new IllegalArgumentException("Invalid day: " + day);
        }
        return digit;}

    public Season(LocalDate startDate, LocalDate endDate, String[] daysWeek, LocalTime startTime,
            LocalTime endTime) {
        for (int i = 0; i < daysWeek.length; i++){
           int digit = mapDayToDigit(daysWeek[i]);
           daysWeek[digit] += 1;
        }
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = new ArrayList<LocalTime>();
        setStartTime(startTime);
        this.endTime = new ArrayList<LocalTime>();
        setEndTime(endTime);
    }

    public Season(LocalDate startDate, LocalDate endDate, String day, LocalTime startTime,
            LocalTime endTime) {
       
        int digit = mapDayToDigit(day);
        daysWeek[digit] += 1;
        
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = new ArrayList<LocalTime>();
        setStartTime(startTime);
        this.endTime = new ArrayList<LocalTime>();
        setEndTime(endTime);
    }

    public Season(LocalDate startDate, LocalDate endDate){
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = new ArrayList<LocalTime>();
        this.endTime = new ArrayList<LocalTime>();
        this.daysWeek = new int[7];
    }

    public void setNewTimeSlot(LocalTime start, LocalTime end, String dayWeek){
        if(!startTime.contains(start))
        this.startTime.add(start);
        if(!endTime.contains(end))
        this.endTime.add(end);
        this.daysWeek[mapDayToDigit(dayWeek)] += 1;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public int[] getDaysWeek() {
        return daysWeek;
    }

    public void setDaysWeek(int[] daysWeek) {
        this.daysWeek = daysWeek;
    }

    public void addDaysWeek(String day) {
        this.daysWeek[mapDayToDigit(day)] += 1;
    }

    public List<LocalTime> getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime.add(startTime);
    }
    public List<LocalTime> getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime.add(endTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("From " + startDate + " until " + endDate + " the availabilities are as follows \n");
        for (int i = 0; i < daysWeek.length; i ++){
            int timeslots_per_day = daysWeek[i];
            
            if( timeslots_per_day > 0){
                sb.append(mapDigitToDay(i) + ": \n") ;
                for (int j = 0; j < timeslots_per_day; j ++){
                    sb.append(startTime.get(j) + " - " + endTime.get(j) + "\n");
                }
            }

        }
        return sb.toString();
    
    

    }

    public static void main(String[] args){
        LocalDate starDate = LocalDate.of(2024,06,05);
        LocalDate endDate = LocalDate.of(2024, 06, 30);
        LocalTime startTime = LocalTime.of(12,34);
        LocalTime endTime = LocalTime.of(14, 50);
        LocalTime startTime1 = LocalTime.of(14,50);
        LocalTime endTime1 = LocalTime.of(15, 50);
        Season summer_availabilites = new Season(starDate, endDate, "Monday", startTime, endTime);
        summer_availabilites.addDaysWeek("Tuesday");
        summer_availabilites.setNewTimeSlot(startTime1, endTime1, "Tuesday");
        summer_availabilites.setNewTimeSlot(startTime1, endTime1, "Thursday");
        System.out.println(summer_availabilites);
    }
    

    
}
