package com.soen342.demo.ServiceInterfaces;

import java.util.List;

import com.soen342.demo.dto.TimeSlotDto;

public interface TimeSlotService {
    TimeSlotDto createTimeSlot(TimeSlotDto timeSlotDto);
    TimeSlotDto getTimeSlotbyId(int id);
    TimeSlotDto updateTimeSlot(int timeSlotId, TimeSlotDto timeSlotDto);
    void deleteTimeSlot(int timeSlotId);
    List<TimeSlotDto> getAllTimeSlots();
}
