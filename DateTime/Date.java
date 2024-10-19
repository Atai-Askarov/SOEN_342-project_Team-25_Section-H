package DateTime;

import java.time.LocalDate;
import java.util.HashMap;

public class Date {
    private int day;
    private int month;
    private int year;

    private static final HashMap<String, Integer> monthDays = new HashMap<>();

    private static final HashMap<Integer, String> alphaNumMonths = new HashMap<>();
    static {
        monthDays.put("January", 31);
        monthDays.put("February", 28); // Assuming no leap year for simplicity
        monthDays.put("March", 31);
        monthDays.put("April", 30);
        monthDays.put("May", 31);
        monthDays.put("June", 30);
        monthDays.put("July", 31);
        monthDays.put("August", 31);
        monthDays.put("September", 30);
        monthDays.put("October", 31);
        monthDays.put("November", 30);
        monthDays.put("December", 31);
    }
    static{
        alphaNumMonths.put(1, "January");
        alphaNumMonths.put(2, "February");
        alphaNumMonths.put(3, "March");
        alphaNumMonths.put(4, "April");
        alphaNumMonths.put(5, "May");
        alphaNumMonths.put(6, "June");
        alphaNumMonths.put(7, "July");
        alphaNumMonths.put(8, "August");
        alphaNumMonths.put(9, "September");
        alphaNumMonths.put(10, "October");
        alphaNumMonths.put(11, "November");
        alphaNumMonths.put(12, "December");
    }


    public Date(int day, int month, int year) throws IllegalArgumentException {
        int currentYear = LocalDate.now().getYear();
        if(year < currentYear)
            throw new IllegalArgumentException("Invalid year: " + year);
        this.year = year;

        // Validate month
        if (month > 12 || month < 0) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        this.month = month;
        
        
        if (day < 1 || day > monthDays.get(alphaNumMonths.get(month))) {
            throw new IllegalArgumentException("Day out of range for month " + month + ": " + day);
        }
        this.day = day;
    }


    public int getDay() {
        return day;
    }


    public void setDay(int day) {
        this.day = day;
    }


    public int getMonth() {
        return month;
    }


    public void setMonth(int month) {
        this.month = month;
    }


    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public static HashMap<String, Integer> getMonthdays() {
        return monthDays;
    }


    public static HashMap<Integer, String> getAlphanummonths() {
        return alphaNumMonths;
    }

    public boolean equals(Object obj) {
        // Check if the object is being compared with itself
        if (this == obj) {
            return true;
        }
        
        // Check if the object is an instance of Date
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
    
        // Cast the object to Date type and compare day, month, and year
        Date otherDate = (Date) obj;
        return this.day == otherDate.day &&
               this.month == otherDate.month &&
               this.year == otherDate.year;
    }
     public String toString(){
        return String.format(String.format("%d,%d,%d", month, day, year));
     }


}
