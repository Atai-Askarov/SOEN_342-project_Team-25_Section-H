package com.soen342.demo.Location;

import java.util.List;
import java.util.ArrayList;
import com.soen342.demo.DateTime.Schedule;
import com.soen342.demo.Service.Lesson;

public class Location {
    private String name;
    private Schedule schedule; // schedule of the location. a several-hour window over a span of several days a
    private String address;
    private String city;
    private List<Lesson> lessons = new ArrayList<Lesson>();

    public Location(String name, Schedule schedule, String address) {
        this.name = name;
        this.schedule = schedule;
        this.address = address;
    }
    public Location(String name, Schedule schedule, String address, List<Lesson> lessons) {
        this.name = name;
        this.schedule = schedule;
        this.address = address;
        this.lessons = lessons;
    }
    public Location(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Location(){}

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
    public List<Lesson> getLessons() {
        return lessons;
    }
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
    }
    public void removeLesson(Lesson lesson){
        this.lessons.remove(lesson);
    }

}