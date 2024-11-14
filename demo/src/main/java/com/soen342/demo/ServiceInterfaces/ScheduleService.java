package com.soen342.demo.ServiceInterfaces;

import java.util.List;

import com.soen342.demo.dto.ScheduleDto;

public interface ScheduleService {
    ScheduleDto createSchedule(ScheduleDto scheduleDto);
    ScheduleDto getSchedulebyId(int id);
    ScheduleDto updateSchedule(int scheduleId, ScheduleDto scheduleDto);
    void deleteSchedule(int scheduleId);
    List<ScheduleDto> getAllSchedules();
}
