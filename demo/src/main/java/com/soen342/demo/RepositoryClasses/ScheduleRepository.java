package com.soen342.demo.RepositoryClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import com.soen342.demo.IdentityClasses.ScheduleIdentity;

public interface ScheduleRepository extends JpaRepository<ScheduleIdentity, Integer> {

}
