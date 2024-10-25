package DateTime;
import java.util.List;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {
    List<Season> season;
    LocalTime openHours;
    LocalTime closeHours;

    

    public Schedule(List <Season> season, LocalTime openHours, LocalTime closeHours) {
        this.season = season;
        this.openHours = openHours;
        this.closeHours = closeHours;
    }

    public Schedule(Season season, LocalTime openHours, LocalTime closeHours) {
        this.season = new ArrayList<Season>();
        setSeason(season);
        this.openHours = openHours;
        this.closeHours = closeHours;
    }
    public List<Season> getSeason() {
        return this.season;
    }
    public boolean seasonExists(Season season){
        return this.season.contains(season);
    }
    public void setSeason(Season season) {
        if (season != null && !this.seasonExists(season))
            this.season.add(season);
    }
    public LocalTime getOpenHours() {
        return openHours;
    }
    public void setOpenHours(LocalTime openHours) {
        this.openHours = openHours;
    }
    public LocalTime getCloseHours() {
        return closeHours;
    }
    public void setCloseHours(LocalTime closeHours) {
        this.closeHours = closeHours;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Day to Day availabilities are ");
        sb.append(openHours);
        sb.append(" - ");
        sb.append(closeHours);
        sb.append("\n");
        for (int i = 0; i < season.size(); i ++){
            sb.append(season.get(i).toString() + "\n");
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Season> seasons = new ArrayList<Season>();
        LocalDate start = LocalDate.of(2024, 06, 30);
        LocalDate end = LocalDate.of(2024, 07, 6);
        LocalTime startTime = LocalTime.of(14,30);
        LocalTime endTime = LocalTime.of(16,30);
        LocalTime openHours = LocalTime.of(9,00);
        LocalTime closeHours = LocalTime.of(17,00);
        String[] days = {"Monday", "Tuesday"};
        
        
        Season summer = new Season(start,end);

        for(int i = 0; i < days.length; i++){
            summer.setNewTimeSlot(startTime, endTime, days[i]);
        }

        seasons.add(summer);
        Schedule schedule = new Schedule(summer, openHours, closeHours);
        System.out.println(schedule);
        
    }
    
}
