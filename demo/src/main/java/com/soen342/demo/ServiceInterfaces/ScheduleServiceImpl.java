package com.soen342.demo.ServiceInterfaces;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soen342.demo.IdentityClasses.ScheduleIdentity;
import com.soen342.demo.MapperClasses.ScheduleMapper;
import com.soen342.demo.RepositoryClasses.ScheduleRepository;
import com.soen342.demo.dto.ScheduleDto;
import com.soen342.demo.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleDto createSchedule(ScheduleDto ScheduleDto){
        ScheduleIdentity Schedule= ScheduleMapper.maptoScheduleIdentity(ScheduleDto);
        ScheduleIdentity savedSchedule = scheduleRepository.save(Schedule);

        return ScheduleMapper.maptoScheduleDto(savedSchedule);
    
    };
    public ScheduleDto getSchedulebyId(int id){
        ScheduleIdentity Schedule = scheduleRepository.findById(id)
                                        .orElseThrow(() -> 
                                        new ResourceNotFoundException("Schedule does not exist with the given ID"));

        return ScheduleMapper.maptoScheduleDto(Schedule);

    };
    public ScheduleDto updateSchedule(int scheduleId, ScheduleDto scheduleDto){
        ScheduleIdentity schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new ResourceNotFoundException("The schedule attributed to this id hasn't been found: " + scheduleId) );
        schedule.setSeason_id(scheduleDto.getSeason_id());
        schedule.setOpening_hours(scheduleDto.getOpening_hours());
        schedule.setClosing_hours(scheduleDto.getClosing_hours());

    ScheduleIdentity updatedSchedule = scheduleRepository.save(schedule);
    return ScheduleMapper.maptoScheduleDto(updatedSchedule);
}

    public void deleteSchedule(int scheduleId){
        scheduleRepository.findById(scheduleId).orElseThrow(() -> new ResourceNotFoundException("The schedule attributed to this id hasn't been found: " + scheduleId) );
        scheduleRepository.deleteById(scheduleId);
    }

    public List<ScheduleDto> getAllSchedules(){
        List<ScheduleIdentity> schedules = scheduleRepository.findAll();
        return schedules.stream().map((schedule) -> ScheduleMapper.maptoScheduleDto(schedule)).collect(Collectors.toList());
    }
    }
