package com.soen342.demo.IdentityClasses;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "schedule")

public class ScheduleIdentity {
    @Id 
    @Column(name = "schedule_id") private int schedule_id;
    @Column(name = "season_id") private int season_id;
    @Column(name = "opening_hours") private LocalTime opening_hours;
    @Column(name = "closing_hours") private LocalTime closing_hours;
    @Column(name = "owner_id") private int owner_id;

}
