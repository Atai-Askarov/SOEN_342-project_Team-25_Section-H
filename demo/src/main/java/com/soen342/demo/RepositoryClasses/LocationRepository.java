package com.soen342.demo.RepositoryClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soen342.demo.IdentityClasses.LocationIdentity;

public interface LocationRepository extends JpaRepository<LocationIdentity, Integer>{

}
