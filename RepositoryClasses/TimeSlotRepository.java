package com.soen342.demo.RepositoryClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soen342.demo.IdentityClasses.TimeSlotIdentity;

public interface TimeSlotRepository extends JpaRepository<TimeSlotIdentity, Integer> {

}
