package com.soen342.demo.RepositoryClasses;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.soen342.demo.IdentityClasses.InstructorIdentity;

public interface InstructorRepository extends JpaRepository<InstructorIdentity, Integer> {
 @Query("SELECT i FROM InstructorIdentity i WHERE i.phone_number = ?1")
    Optional<InstructorIdentity> findByPhoneNumber(String phoneNumber);
}
