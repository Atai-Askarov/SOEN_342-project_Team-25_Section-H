package com.soen342.demo.RepositoryClasses;


import org.springframework.data.jpa.repository.JpaRepository;
import com.soen342.demo.IdentityClasses.InstructorIdentity;

public interface InstructorRepository extends JpaRepository<InstructorIdentity, Integer> {

}
