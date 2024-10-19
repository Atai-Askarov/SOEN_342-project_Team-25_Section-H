package Actors.Instructor_Lesson;
import java.util.ArrayList;

import DateTime.Schedule;
import DateTime.Time;

public class Instructor {
    private String name;
    private int phone_number;
    private ArrayList<String> specialization; // Changed to ArrayList
    private Schedule availability;
    private ArrayList<String> city;


    public Instructor(String name, int phone_number, ArrayList<String> specialization, Schedule availability,
            ArrayList<String> city) {
        this.name = name;
        this.phone_number = phone_number;
        this.specialization = specialization;
        this.availability = availability;
        this.city = city;
    }

    public Instructor(String name, int phone_number, String specialization, Schedule availability,
            String city) {
        this.name = name;
        this.phone_number = phone_number;
        this.specialization = new ArrayList<>();
        this.specialization.add(specialization);
        this.availability = availability;
        this.city = new ArrayList<>();
        this.city.add(specialization);
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
    public ArrayList<String> getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization.add(specialization);
    }
    public Schedule getAvailability() {
        return availability;
    }
    public void setAvailability(Schedule availability) {
        this.availability = availability;
    }
    public ArrayList<String> getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city.add(city);
    }

    public String toString() {
        // Building the specialization string
        StringBuilder specializationString = new StringBuilder();
        for (int i = 0; i < specialization.size(); i++) {
            specializationString.append(specialization.get(i));
            if (i < specialization.size() - 1) {
                specializationString.append(", "); // Add comma except for the last element
            }
        }

        // Building the city string
        StringBuilder cityString = new StringBuilder();
        for (int i = 0; i < city.size(); i++) {
            cityString.append(city.get(i));
            if (i < city.size() - 1) {
                cityString.append(", "); // Add comma except for the last element
            }
        }

        // Creating the final output
        return name + ", whose phone number is " + phone_number +
               ", specializes in " + specializationString.toString() +
               ", whose availability is as follows: " + availability.toString() +
               ", and who resides in " + cityString.toString() + ".";
    }
    public static void main(String[] args) {
        Schedule one = new Schedule("09.01.2024", "11.01.2024", "Monday", new Time(5,30), new Time(7,30));
        Instructor dima = new Instructor("Dima", 438, "plumber", one, "Montreal");
        System.out.println(dima);
    }
}