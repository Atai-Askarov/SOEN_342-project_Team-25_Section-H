package com.soen342.demo.ControllerClasses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soen342.demo.dto.InstructorDto;
import com.soen342.demo.ServiceInterfaces.InstructorService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Service
@AllArgsConstructor
@RestController
@RequestMapping("/api/instructor")
public class InstructorController {
    private InstructorService instructorService;
    //Build POST instructor REST API 
    @PostMapping
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorDto instructorDto){
        InstructorDto savedInstructor = instructorService.createInstructor(instructorDto);
        return new ResponseEntity<>(savedInstructor, HttpStatus.CREATED);
    }

    // Build GET instructor REST API
    @GetMapping("{id}")
    public ResponseEntity<InstructorDto> getInstructorbyId(@PathVariable("id") int instructorId){
        InstructorDto instructorDto = instructorService.getInstructorbyId(instructorId);
        return new ResponseEntity<>(instructorDto, HttpStatus.OK);
    }


}
