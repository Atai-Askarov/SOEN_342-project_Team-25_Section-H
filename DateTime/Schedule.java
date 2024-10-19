package DateTime;
import java.util.List;
import java.util.ArrayList;

public class Schedule {
    private List<Date> startDate;
    private List<Date> endDate;
    private int[] daysWeek;
    private List<Time> startTime;
    private List<Time> endTime;

    
    //season: startdate - enddate
    //timeslot: starttime - endtime
    //daysweek: array of 7 integers that show how many timeslots are there in a day

    public Schedule(List<Date> startDate, List<Date> endDate, String day , Time startTime,
            Time endTime) {
        this.startDate = startDate; // if there are multiple seasons, it will recieve an array of date
        this.endDate = endDate; //we'll have 2 seasons during which all the rest will apply: days of the weel and timeslots

        this.daysWeek = new int[7]; 
        setDaysWeek(day);
        
        this.startTime = new ArrayList<>();
        this.startTime.add(startTime);
        
        this.endTime = new ArrayList<>();
        this.endTime.add(endTime);
    }

    public Schedule(Date startDate, Date endDate, String day, Time startTime, Time endTime) {
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
        
    }

    public void setSeason(Date start, Date end){
        setstartDate(start);
        setendDate(end);
    }
    public String printSeasons(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < startDate.size(); i++){
            sb.append(startDate.get(i).toString()) // Assuming single start date
            .append(" until ")
            .append(endDate.get(i).toString()) // Assuming single end date
            .append("\n");
        }
        return sb.toString();
    }
    public List<Date> getstartDate() {
        return startDate;
    }


    public void setstartDate(Date startDate) {
        this.startDate.add(startDate);
    }


    public List<Date> getendDate() {
        return endDate;
    }


    public void setendDate(Date endDate) {
        this.endDate.add(endDate);
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

        for (int i = 0; i < startDate.size(); i++) {
            sb.append("starting from ")
            .append(startDate.get(i)) // Assuming single start date
            .append(" until ")
            .append(endDate.get(i)) // Assuming single end date
            .append("\n");}

            for(int j = 0; j < daysWeek.length; j++){
                if (daysWeek[j] > 0) { // Check if the day has any availability
                    String dayName = getDayName(j);
                    sb.append(dayName) 
                      .append(": from ")
                      .append(startTime.get(0).toString()) // Assumes Time is properly formatted
                      .append(" to ")
                      .append(endTime.get(0).toString())
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
        Date start = new Date(9,1,2024);
        Date end = new Date(11,1,2024);
        Date start1 = new Date(6,1,2024);
        Date end1 = new Date(7,1,2024);
        Schedule one = new Schedule(start, end, "Monday", new Time(5,30), new Time(7,30));
        one.setDaysWeek("Thursday");
        one.setSeason(start1, end1);
        
        System.out.println(one);
    }
    
}
