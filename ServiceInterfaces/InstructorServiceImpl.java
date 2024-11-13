package com.soen342.demo.ServiceInterfaces;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
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

    public InstructorDto updateInstructor(int instructorId, InstructorDto instructorDto){
        InstructorIdentity instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new ResourceNotFoundException("The instructor attributed to this id hasn't been found: " + instructorId) );
        instructor.setFirst_name(instructorDto.getFirst_name());
        instructor.setLast_name(instructorDto.getLast_name());
        instructor.setPhone_number(instructorDto.getPhone_number());
        instructor.setInstructor_id(instructorDto.getInstructor_id());
        instructor.setSchedule_id(instructorDto.getSchedule_id());
        instructor.setSeason_id(instructorDto.getSeason_id());
        instructor.setSpecialization(instructorDto.getSpecialization_name());
        instructor.setCity(instructorDto.getCity());
        instructor.setPassword(instructorDto.getPassword());

        InstructorIdentity updatedInstructor = instructorRepository.save(instructor);
        return InstructorMapper.maptoInstructoDto(updatedInstructor);
    }
    public void deleteInstructor(int instructorId){
        instructorRepository.findById(instructorId).orElseThrow(() -> new ResourceNotFoundException("The instructor attributed to this id hasn't been found: " + instructorId) );
        

        instructorRepository.deleteById(instructorId);
        }
}

