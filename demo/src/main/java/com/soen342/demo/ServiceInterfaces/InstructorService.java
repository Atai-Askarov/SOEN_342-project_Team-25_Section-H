package com.soen342.demo.ServiceInterfaces;

import java.util.List;

import com.soen342.demo.dto.InstructorDto;
import com.soen342.demo.exception.ResourceNotFoundException;

public interface InstructorService {
    InstructorDto createInstructor(InstructorDto instructorDto);
    InstructorDto getInstructorbyId(int id);
    InstructorDto updateInstructor(int instructorId, InstructorDto instructorDto);
    void deleteInstructor(int instructorId);
    List<InstructorDto> getAllInstructors();
    InstructorDto getInstructorbyPhoneNumber(String phoneNumber);

}
