package com.soen342.demo.IdentityClasses;


import jakarta.persistence.Id;

import java.time.LocalTime;

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
@Table(name = "timeslot")
public class TimeSlotIdentity {
    @Id 
    @Column(name = "timeslot_id") private int timeslot_id;
    @Column(name = "weekday") private int weekday;
    @Column(name = "start_time") private LocalTime start_time;
    @Column(name = "end_time") private LocalTime end_time;
    @Column(name = "activity") private String activity;
}
