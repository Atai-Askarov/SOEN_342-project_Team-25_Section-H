package com.soen342.demo.ServiceInterfaces;

import java.util.List;

import com.soen342.demo.dto.LocationDto;

public interface LocationService {
    LocationDto createLocation(LocationDto LocationDto);
    LocationDto getLocationbyId(int id);
    LocationDto updateLocation(int LocationId, LocationDto LocationDto);
    void deleteLocation(int LocationId);
    List<LocationDto> getAllLocations();
}
