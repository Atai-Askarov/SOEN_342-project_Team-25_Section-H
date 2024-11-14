package com.soen342.demo.MapperClasses;

import com.soen342.demo.IdentityClasses.TimeSlotIdentity;
import com.soen342.demo.dto.TimeSlotDto;

public class TimeSlotMapper {
    public static TimeSlotDto maptoTimeSlotDto(TimeSlotIdentity timeslot){
        return new TimeSlotDto(
            timeslot.getTimeslot_id(),
            timeslot.getWeekday(),
            timeslot.getStart_time(),
            timeslot.getEnd_time(),
            timeslot.getActivity()
        );

    }

    public static TimeSlotIdentity maptoTimeSlotIdentity(TimeSlotDto timeslot){
        return new TimeSlotIdentity(
            timeslot.getTimeslot_id(),
            timeslot.getWeekday(),
            timeslot.getStart_time(),
            timeslot.getEnd_time(),
            timeslot.getActivity()
        );
    }
}
