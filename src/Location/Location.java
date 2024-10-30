package src.Location;

import DateTime.Schedule;

public class Location {
    private String name;
    private Schedule schedule; // schedule of the location. a several-hour window over a span of several days a
                               // week
    private String address;

     

        this.schedule = schedule;
        this.address = address;
     

    }
    public String getName() {
     

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