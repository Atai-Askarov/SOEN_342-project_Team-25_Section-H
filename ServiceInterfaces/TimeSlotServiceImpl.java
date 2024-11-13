package com.soen342.demo.ServiceInterfaces;

import org.springframework.stereotype.Service;

import com.soen342.demo.IdentityClasses.TimeSlotIdentity;
import com.soen342.demo.MapperClasses.TimeSlotMapper;
import com.soen342.demo.RepositoryClasses.TimeSlotRepository;
import com.soen342.demo.dto.TimeSlotDto;
import com.soen342.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TimeSlotServiceImpl implements TimeSlotService{

private TimeSlotRepository timeSlotRepository;

    public TimeSlotDto createTimeSlot(TimeSlotDto timeSlotDto){
        TimeSlotIdentity timeSlot= TimeSlotMapper.maptoTimeSlotIdentity(timeSlotDto);
        TimeSlotIdentity savedTimeSlot = timeSlotRepository.save(timeSlot);

        return TimeSlotMapper.maptoTimeSlotDto(savedTimeSlot);
    
    };
    public TimeSlotDto getTimeSlotbyId(int id){
        TimeSlotIdentity timeslot = timeSlotRepository.findById(id)
                                        .orElseThrow(() -> 
                                        new ResourceNotFoundException("TimeSlot does not exist with the given ID"));

        return TimeSlotMapper.maptoTimeSlotDto(timeslot);

    };
}
