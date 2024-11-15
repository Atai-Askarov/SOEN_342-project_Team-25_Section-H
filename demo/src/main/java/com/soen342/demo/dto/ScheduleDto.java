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
public class ScheduleDto {
    private int schedule_id;
    private int season_id;
    private LocalTime opening_hours;
    private LocalTime closing_hours;
    private int owner_id;
;}
