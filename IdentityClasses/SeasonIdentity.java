package com.soen342.demo.IdentityClasses;
import jakarta.persistence.Id;

import java.time.LocalDate;

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
@Table(name = "season")
public class SeasonIdentity {
    @Id 
    @Column(name = "season_id") private int season_id;
    @Column(name = "start_date") private LocalDate start_date;
    @Column(name = "end_date") private LocalDate end_date;
    @Column(name = "timeslot_id") private int timeslot_id;

}
