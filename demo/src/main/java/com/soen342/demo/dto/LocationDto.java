package com.soen342.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private int location_id;
    private String address;
    private String city;
    private String location_name;
    private int schedule_id;
    private int season_id;
}
