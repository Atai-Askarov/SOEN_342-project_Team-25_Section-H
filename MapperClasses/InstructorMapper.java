package com.soen342.demo.MapperClasses;
import com.soen342.demo.dto.InstructorDto;
import com.soen342.demo.IdentityClasses.InstructorIdentity;
public class InstructorMapper {
    public static InstructorDto maptoInstructoDto(InstructorIdentity instructor){
        return new InstructorDto(
            instructor.getInstructor_id(),
            instructor.getPhone_number(),
            instructor.getFirst_name(),
            instructor.getLast_name(),
            instructor.getCity(),
            instructor.getSpecialization(),
            instructor.getSchedule_id(),
            instructor.getSeason_id(),
            instructor.getPassword()
        );

    }

    public static InstructorIdentity maptoInstructoIdentity(InstructorDto instructor){
        return new InstructorIdentity(
            instructor.getInstructor_id(),
            instructor.getPhone_number(),
            instructor.getFirst_name(),
            instructor.getLast_name(),
            instructor.getCity(),
            instructor.getSpecialization_name(),
            instructor.getSchedule_id(),
            instructor.getSeason_id(),
            instructor.getPassword()
        );
    }
}
