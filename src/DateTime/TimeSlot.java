package DateTime;
import java.time.LocalTime;

public class TimeSlot implements Comparable<TimeSlot>{
    private LocalTime start;
    private LocalTime end; 
    private String activity;

    public TimeSlot(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    public TimeSlot(LocalTime start, LocalTime end, String activity) throws InnaccurateDatePlacement{
        this.start = start;
        this.end = end;
        this.activity = activity;
        if(start.isAfter(end))
            throw new InnaccurateDatePlacement();
    }

    public class InnaccurateDatePlacement extends Exception {
        public InnaccurateDatePlacement(String message) {
            super(message);
        }
        public InnaccurateDatePlacement(){
            super("the Start date must be before the end date");
        }
    }

    public LocalTime getStart() {
        return start;
    }
    public void setStart(LocalTime start) throws InnaccurateDatePlacement {
        this.start = start;
        if (this.end != null){
            if (start.isAfter(this.end)){
                throw new InnaccurateDatePlacement();
            }
        }
    }
    public LocalTime getEnd() {
        return end;
    }
    public void setEnd(LocalTime end) throws InnaccurateDatePlacement {
        this.end = end;
        if (this.start != null){
            if (end.isBefore(this.start)){
                throw new InnaccurateDatePlacement();
            }
        }
    }
    public String getActivity() {
        return activity;
    }
    public void setActivity(String activity) {
        this.activity = activity;
    }
    
    public int compareTo(TimeSlot other){
        // First compare by start time
        int startComparison = this.start.compareTo(other.start);
        return startComparison; // Return the result of the start time comparison
    }
    public Boolean isWithinTimeSlot(TimeSlot other){
        return(other.getStart().compareTo(this.start) >= 0 && other.getEnd().compareTo(this.end) <= 0 );
                        
    }

    @Override
    public String toString() {
        if(activity != null)
            return activity + " starts at " + start + " and ends at " + end;
        else 
            return "this event starts at " + start + " and ends at " + end;}

    

}
