package com.soen342.demo.MapperClasses;

import com.soen342.demo.IdentityClasses.LocationIdentity;
import com.soen342.demo.dto.LocationDto;

public class LocationMapper {
    public static LocationDto maptoLocationDto(LocationIdentity Location){
        return new LocationDto(
            Location.getLocation_id(),
            Location.getAddress(),
            Location.getCity(),
            Location.getLocation_name(),
            Location.getSchedule_id(),
            Location.getSeason_id()
        );

    }

    public static LocationIdentity maptoLocationIdentity(LocationDto Location){
        return new LocationIdentity(
            Location.getLocation_id(),
            Location.getAddress(),
            Location.getCity(),
            Location.getLocation_name(),
            Location.getSchedule_id(),
            Location.getSeason_id()
        );
    }
}
