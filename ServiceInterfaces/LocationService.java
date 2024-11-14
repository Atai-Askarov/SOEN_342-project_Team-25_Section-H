package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.LocationDto;

public interface LocationService {
    LocationDto createLocation(LocationDto LocationDto);
    LocationDto getLocationbyId(int id);
}
