package com.soen342.demo.dto;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TimeSlotDto {
    private int timeslot_id;
    private int weekday;
    private LocalTime start_time;
    private LocalTime end_time;
    private String activity;
}
