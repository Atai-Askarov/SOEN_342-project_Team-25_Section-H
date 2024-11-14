package com.soen342.demo.ServiceInterfaces;

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
}
