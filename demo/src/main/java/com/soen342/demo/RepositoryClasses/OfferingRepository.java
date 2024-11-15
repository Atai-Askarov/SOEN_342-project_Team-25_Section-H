package com.soen342.demo.RepositoryClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soen342.demo.IdentityClasses.OfferingIdentity;

public interface OfferingRepository extends JpaRepository<OfferingIdentity, Integer> {

}
