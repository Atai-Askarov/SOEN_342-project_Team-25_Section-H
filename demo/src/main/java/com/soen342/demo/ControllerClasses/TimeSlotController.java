package com.soen342.demo.ControllerClasses;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.soen342.demo.dto.TimeSlotDto;
import com.soen342.demo.ServiceInterfaces.TimeSlotService;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
@RequestMapping("/api/timeslots")
public class TimeSlotController {
    private TimeSlotService TimeSlotService;
    //Build POST TimeSlot REST API 
    @PostMapping
    public ResponseEntity<TimeSlotDto> createTimeSlot(@RequestBody TimeSlotDto TimeSlotDto){
        TimeSlotDto savedTimeSlot = TimeSlotService.createTimeSlot(TimeSlotDto);
        return new ResponseEntity<>(savedTimeSlot, HttpStatus.CREATED);
    
}
    @GetMapping("{id}")
    public ResponseEntity<TimeSlotDto> getTimeSlotbyId(@PathVariable("id") int TimeSlotId){
        TimeSlotDto timeSlotDto = TimeSlotService.getTimeSlotbyId(TimeSlotId);
        return new ResponseEntity<>(timeSlotDto, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<TimeSlotDto> updateTimeSlot(@PathVariable("id") int timeSlotId, 
                                                    @RequestBody TimeSlotDto updateTimeSlot){
        TimeSlotDto timeSlotDto = TimeSlotService.updateTimeSlot(timeSlotId, updateTimeSlot);
        return new ResponseEntity<>(timeSlotDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTimeSlot(@PathVariable("id") int timeSlotId){
        TimeSlotService.deleteTimeSlot(timeSlotId);
        return new ResponseEntity<>("Time Slot has been deleted successfully", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TimeSlotDto>> getAllTimeSlots(){
        List<TimeSlotDto> timeSlots = TimeSlotService.getAllTimeSlots();
        return new ResponseEntity<>(timeSlots, HttpStatus.OK);
    }
    }