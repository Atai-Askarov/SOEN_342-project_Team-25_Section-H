package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.ScheduleDto;

public interface ScheduleService {
    ScheduleDto createSchedule(ScheduleDto scheduleDto);
    ScheduleDto getSchedulebyId(int id);
}
