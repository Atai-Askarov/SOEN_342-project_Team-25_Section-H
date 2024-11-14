package com.soen342.demo.MapperClasses;

import com.soen342.demo.IdentityClasses.ScheduleIdentity;
import com.soen342.demo.dto.ScheduleDto;

public class ScheduleMapper {
    public static ScheduleDto maptoScheduleDto(ScheduleIdentity Schedule){
        return new ScheduleDto(
            Schedule.getSchedule_id(),
            Schedule.getSeason_id(),
            Schedule.getOpening_hours(),
            Schedule.getClosing_hours()
        );

    }

    public static ScheduleIdentity maptoScheduleIdentity(ScheduleDto Schedule){
        return new ScheduleIdentity(
            Schedule.getSchedule_id(),
            Schedule.getSeason_id(),
            Schedule.getOpening_hours(),
            Schedule.getClosing_hours()
        );
    }
}
