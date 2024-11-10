package Admin;

import DateTime.*;
import Location.*;
import Service.*;
import java.time.LocalTime;

public class Admin {
    public void CreateOffering(String mode, Location location, LocalTime startTime, LocalTime endTime,
            Schedule schedule, String status, int capacity) {

    }

    public void CreateOffering(Offering offering) {

    }

    public static void main(String[] args) {
        Admin admin = new Admin();
        Offering off = new Offering();

        admin.CreateOffering(off);
    }
}
