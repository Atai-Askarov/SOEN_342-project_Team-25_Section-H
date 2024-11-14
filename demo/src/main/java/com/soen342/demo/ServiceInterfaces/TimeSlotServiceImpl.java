package com.soen342.demo.ServiceInterfaces;

import java.util.List;
import java.util.stream.Collectors;

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
    public TimeSlotDto updateTimeSlot(int timeSlotId, TimeSlotDto timeSlotDto){
    TimeSlotIdentity timeSlot = timeSlotRepository.findById(timeSlotId).orElseThrow(() -> new ResourceNotFoundException("The time slot attributed to this id hasn't been found: " + timeSlotId) );
    timeSlot.setWeekday(timeSlotDto.getWeekday());
    timeSlot.setStart_time(timeSlotDto.getStart_time());
    timeSlot.setEnd_time(timeSlotDto.getEnd_time());
    timeSlot.setActivity(timeSlotDto.getActivity());

    TimeSlotIdentity updatedTimeSlot = timeSlotRepository.save(timeSlot);
    return TimeSlotMapper.maptoTimeSlotDto(updatedTimeSlot);
}

    public void deleteTimeSlot(int timeSlotId){
        timeSlotRepository.findById(timeSlotId).orElseThrow(() -> new ResourceNotFoundException("The time slot attributed to this id hasn't been found: " + timeSlotId) );
        timeSlotRepository.deleteById(timeSlotId);
    }

    public List<TimeSlotDto> getAllTimeSlots(){
        List<TimeSlotIdentity> timeSlots = timeSlotRepository.findAll();
        return timeSlots.stream().map((timeSlot) -> TimeSlotMapper.maptoTimeSlotDto(timeSlot)).collect(Collectors.toList());
    }
}
