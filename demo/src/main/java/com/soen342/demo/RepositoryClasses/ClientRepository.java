package com.soen342.demo.RepositoryClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soen342.demo.IdentityClasses.ClientIdentity;

public interface ClientRepository extends JpaRepository<ClientIdentity, Integer> {
    ClientIdentity findByPhoneNumber(String phoneNumber);
}
