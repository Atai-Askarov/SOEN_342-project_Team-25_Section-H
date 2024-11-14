package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.InstructorDto;

public interface InstructorService {
    InstructorDto createInstructor(InstructorDto instructorDto);
    InstructorDto getInstructorbyId(int id);
    InstructorDto updateInstructor(int instructorId, InstructorDto instructorDto);
    void deleteInstructor(int instructorId);
}
