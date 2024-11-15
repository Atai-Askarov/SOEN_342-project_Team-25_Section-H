package com.soen342.demo.RepositoryClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import com.soen342.demo.IdentityClasses.LessonIdentity;

public interface LessonRepository extends JpaRepository<LessonIdentity, Integer> {

}
