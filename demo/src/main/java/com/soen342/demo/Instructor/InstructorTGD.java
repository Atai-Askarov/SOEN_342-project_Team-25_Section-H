package com.soen342.demo.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InstructorTGD extends JpaRepository<Instructor, Long>{
    String findByPhoneNumber(String name);

    void createInstructor();

    void deleteInstructor();

    void updateInstructor();

}
