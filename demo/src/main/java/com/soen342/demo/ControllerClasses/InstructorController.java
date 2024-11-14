package com.soen342.demo.ControllerClasses;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.soen342.demo.dto.InstructorDto;
import com.soen342.demo.ServiceInterfaces.InstructorService;

import lombok.AllArgsConstructor;





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

    @PutMapping("{id}")
    public ResponseEntity<InstructorDto> updateInstructor(@PathVariable("id") int instructorId, 
                                                          @RequestBody InstructorDto updateInstructor){
        InstructorDto instructorDto = instructorService.updateInstructor(instructorId,updateInstructor);
        return new ResponseEntity<>(instructorDto, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable("id")int instructorId){
        instructorService.deleteInstructor(instructorId);
        return new ResponseEntity<>("Instructor has been deleted successfully", HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<InstructorDto>> getAllInstructors(){
        List<InstructorDto> instructors = instructorService.getAllInstructors();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }


}
