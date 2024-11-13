package com.soen342.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InstructorDto {
    private int instructor_id;
    private String phone_number;
    private String first_name;
    private String last_name;
    private String city;
    private String specialization_name;
    private int schedule_id;
    private int season_id;
    private String password;
}
