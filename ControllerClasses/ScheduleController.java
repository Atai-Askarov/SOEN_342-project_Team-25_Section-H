package com.soen342.demo.ControllerClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soen342.demo.ServiceInterfaces.ScheduleService;
import com.soen342.demo.dto.ScheduleDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService ScheduleService;
    //Build POST Schedule REST API 
    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(@RequestBody ScheduleDto ScheduleDto){
        ScheduleDto savedSchedule = ScheduleService.createSchedule(ScheduleDto);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    // Build GET Schedule REST API
    @GetMapping("{id}")
    public ResponseEntity<ScheduleDto> getSchedulebyId(@PathVariable("id") int ScheduleId){
        ScheduleDto ScheduleDto = ScheduleService.getSchedulebyId(ScheduleId);
        return new ResponseEntity<>(ScheduleDto, HttpStatus.OK);
    }
}
