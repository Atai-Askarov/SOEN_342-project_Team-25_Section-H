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
@Table(name = "lesson")
public class LessonIdentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private int lessonId;

    @Column(name = "location_id")
    private int locationId;

    @Column(name = "timeslot_id")
    private int timeslotId;

    @Column(name = "mode_")
    private String mode;

    @Column(name = "status")
    private String status;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "lessonName")
    private String lessonName;
}
