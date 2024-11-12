package com.soen342.demo.DateTime;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.time.LocalTime; 
import com.soen342.demo.DateTime.TimeSlot;
import com.soen342.demo.DateTime.TimeSlot.InnaccurateTimePlacement;

public class Season {
    private LocalDate startDate;
    private LocalDate endDate;
    List<List<TimeSlot>> daysWeek = new ArrayList<>(7);
    HashMap<String, List<TimeSlot>> map = new HashMap<>();


    public Season(){
        for (int i = 0; i < 7; i ++){
            daysWeek.add(i, new ArrayList<>());
        }
    }

    public Season(LocalDate startDate, LocalDate endDate, String day, TimeSlot timeslot) {
       
        this.startDate = startDate;
        this.endDate = endDate;
        for (int i = 0; i < 7; i ++){
            daysWeek.add(i, new ArrayList<>());
        }
        int digit = mapDayToDigit(day);
        daysWeek.get(digit).add(timeslot);
        
        
    }

    public Season(LocalDate startDate, LocalDate endDate){
        this.startDate = startDate;
        this.endDate = endDate;
        
        for (int i = 0; i < 7; i ++){
            daysWeek.add(i, new ArrayList<>());
        }    
    }


    
    public Boolean isWithinDateInterval(LocalDate[] other){
        // is the passed date interval within the current object's interval?
        if(other.length == 2){
                LocalDate[] this_interval = getDateInterval();
                LocalDate this_startDate = this_interval[0];
                LocalDate this_endDate = this_interval[1];
                LocalDate other_startDate = other[0];
                LocalDate other_endDate = other[1];
                System.out.println("The interval is within range");
                return (other_startDate.isEqual(this_startDate) || other_startDate.isAfter(this_startDate)) &&
                (other_endDate.isEqual(this_endDate) || other_endDate.isBefore(this_endDate));
            }

        else 
            System.out.println("The interval length isn't 2, so can't do notin");

        return false;
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

    public void setTimeSlot(TimeSlot thisTimeSlot, String dayWeek){
        int day_position = mapDayToDigit(dayWeek);
        List<TimeSlot> dayTimeslots = daysWeek.get(day_position);
        if(dayTimeslots.size() == 0){
            dayTimeslots.add(thisTimeSlot);
        }

        for (int i = 0; i < dayTimeslots.size(); i++){
            TimeSlot otherTimeSlot = dayTimeslots.get(i);
            if (thisTimeSlot.isWithinTimeSlot(otherTimeSlot)){
                int position_indicator = thisTimeSlot.compareTo(otherTimeSlot);
                if(position_indicator == -1) // add before the other timeslot
                    if (i == 0){
                        dayTimeslots.add(0, thisTimeSlot);
                        break;
                    }
                    else{
                        dayTimeslots.add(i-1, thisTimeSlot);
                        break;}
                else if(position_indicator == 1){ // add after the other timeslot
                    dayTimeslots.add(i + 1,thisTimeSlot);
                    break;}
                if (position_indicator == 0) // an overlap exists, so can't add this timeSlot
                    System.out.println("Overlap, so naynay. Most likely smth is wrong, there is another check for that");
            }
    }}

    private LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    private LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public List <TimeSlot> getTimeSlotIntervalsByDay (String day){
        int digit = mapDayToDigit(day);
        return daysWeek.get(digit);
    }

    //public List<TimeSlot> getTimeSlotIntervalsByActivity(String activity){

    //}

    public LocalDate[] getDateInterval(){
        LocalDate[] interval = {getStartDate(), getEndDate()};
        return interval;
    }

    void setBoundaries(LocalTime openHours, LocalTime closeHours){
        for (int i = 0; i < daysWeek.size(); i ++){
            daysWeek.get(i).add(0,new TimeSlot(openHours, true));
            daysWeek.get(i).add(new TimeSlot(closeHours, false));
        }

    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((daysWeek == null) ? 0 : daysWeek.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Season other = (Season) obj;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (daysWeek == null) {
            if (other.daysWeek != null)
                return false;
        } else if (!daysWeek.equals(other.daysWeek))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("This season lasts from ");
        sb.append(startDate.toString() + " until " + endDate.toString() + "\n");
        sb.append("The timeslots are as follows \n");
        for (int i = 0; i < daysWeek.size(); i ++){
            String day = mapDigitToDay(i);
            List<TimeSlot> dayList = daysWeek.get(i);
            if (!daysWeek.get(i).isEmpty()){
                sb.append(day + ": \n");
                for (int j = 0; j < dayList.size(); j++){
                    TimeSlot period = dayList.get(j);
                    sb.append(period.getStart() + " - " + period.getEnd() + "\n");
                }
                
            }
        }

        return sb.toString();}
    

    public static void main(String[] args){
        LocalDate startDate = LocalDate.of(2024,06,05);
        LocalDate endDate = LocalDate.of(2024, 06, 30);
        LocalTime startTime = LocalTime.of(12,34);
        LocalTime endTime = LocalTime.of(14, 50);
        LocalTime startTime1 = LocalTime.of(14,50);
        LocalTime endTime1 = LocalTime.of(15, 50);
        LocalTime startTime2 = LocalTime.of(14,50);
        LocalTime endTime2 = LocalTime.of(15,30);
        TimeSlot one;
        TimeSlot two;
        TimeSlot three;
        try{
            one = new TimeSlot(startTime1, endTime1);
            two = new TimeSlot(startTime, endTime);
            three = new TimeSlot(startTime2, endTime2);
            Season summerSeason = new Season(startDate, endDate, "Monday", one);
            summerSeason.setTimeSlot(two, "Tuesday");
            summerSeason.setTimeSlot(two, "Monday");
            summerSeason.setTimeSlot(three, "Monday");
            System.out.println(summerSeason);
        
        }
        catch(InnaccurateTimePlacement e){
                System.out.println(e.getMessage());
            }

        
    }
    
}
    

