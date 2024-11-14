package com.soen342.demo.RepositoryClasses;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soen342.demo.IdentityClasses.SeasonIdentity;

public interface SeasonRepository extends JpaRepository<SeasonIdentity, Integer> {

}
