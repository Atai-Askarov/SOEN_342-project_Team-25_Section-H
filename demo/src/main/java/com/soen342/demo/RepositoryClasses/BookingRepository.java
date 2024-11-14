package com.soen342.demo.RepositoryClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soen342.demo.IdentityClasses.BookingIdentity;

public interface BookingRepository extends JpaRepository<BookingIdentity, Integer> {

}
