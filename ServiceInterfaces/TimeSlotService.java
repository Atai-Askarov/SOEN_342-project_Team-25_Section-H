package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.TimeSlotDto;

public interface TimeSlotService {
    TimeSlotDto createTimeSlot(TimeSlotDto timeSlotDto);
    TimeSlotDto getTimeSlotbyId(int id);
}
