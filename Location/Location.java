package Location;

import DateTime.Schedule;

public class Location {
    private String name;
    private Schedule schedule; //schedule of the location. a several-hour window over a span of several days a week
    private String  address;
    private String city;

    

    public Location(String name, Schedule schedule, String address, String city) {
        this.name = name;
        this.schedule = schedule;
        this.address = address;
        this.city = city;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Schedule getSchedule() {
        return schedule;
    }
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
}
