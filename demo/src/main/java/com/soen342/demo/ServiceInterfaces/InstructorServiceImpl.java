package com.soen342.demo.ServiceInterfaces;

import org.springframework.stereotype.Service;

import com.soen342.demo.MapperClasses.InstructorMapper;
import com.soen342.demo.RepositoryClasses.InstructorRepository;
import com.soen342.demo.dto.InstructorDto;
import com.soen342.demo.exception.ResourceNotFoundException;
import com.soen342.demo.IdentityClasses.InstructorIdentity;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorServiceImpl implements InstructorService{
    private InstructorRepository instructorRepository;

    public InstructorDto createInstructor(InstructorDto instructorDto){
        InstructorIdentity instructor = InstructorMapper.maptoInstructoIdentity(instructorDto);
        InstructorIdentity savedInstructor = instructorRepository.save(instructor);

        return InstructorMapper.maptoInstructoDto(savedInstructor);
    };
    
    public InstructorDto getInstructorbyId(int id) throws ResourceNotFoundException
    {
        InstructorIdentity instructor = instructorRepository.findById(id)
                                        .orElseThrow(() -> 
                                        new ResourceNotFoundException("Instructor does not exist with the given ID"));

        return InstructorMapper.maptoInstructoDto(instructor);
    };
}

