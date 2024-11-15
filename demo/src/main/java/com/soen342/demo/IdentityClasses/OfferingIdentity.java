package com.soen342.demo.IdentityClasses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "offering")
public class OfferingIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offering_id")
    private int offeringId;

    @Column(name = "lesson_id", nullable = false)
    private int lessonId;

    @Column(name = "instructor_id", nullable = false)
    private int instructorId;
}
