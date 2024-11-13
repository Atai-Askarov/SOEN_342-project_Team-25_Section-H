package com.soen342.demo.IdentityClasses;


import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "instructor")
public class InstructorIdentity {
    @Id 
    @Column(name = "instructor_id") private int instructor_id;
    @Column(name = "first_name") private String first_name;
    @Column(name = "last_name") private String last_name;
    @Column(name = "phone_number", nullable = false, unique = true) private String phone_number;
    @Column(name = "specialization") private String specialization;
    @Column(name = "city_name") private String city;
    @Column(name = "schedule_id", nullable = false, unique = true) private int schedule_id;
    @Column(name = "season_id", nullable = false) private int season_id;
    
}



