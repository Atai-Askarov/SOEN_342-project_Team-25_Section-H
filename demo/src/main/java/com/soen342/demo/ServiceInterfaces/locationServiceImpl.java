package com.soen342.demo.ServiceInterfaces;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.soen342.demo.IdentityClasses.LocationIdentity;
import com.soen342.demo.MapperClasses.LocationMapper;
import com.soen342.demo.RepositoryClasses.LocationRepository;
import com.soen342.demo.dto.LocationDto;
import com.soen342.demo.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class locationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository LocationRepository;

    public LocationDto createLocation(LocationDto LocationDto){
        LocationIdentity Location= LocationMapper.maptoLocationIdentity(LocationDto);
        LocationIdentity savedLocation = LocationRepository.save(Location);

        return LocationMapper.maptoLocationDto(savedLocation);
    
    };
    public LocationDto getLocationbyId(int id){
        LocationIdentity Location = LocationRepository.findById(id)
                                        .orElseThrow(() -> 
                                        new ResourceNotFoundException("Location does not exist with the given ID"));

        return LocationMapper.maptoLocationDto(Location);

    };
    public LocationDto updateLocation(int locationId, LocationDto locationDto){
    LocationIdentity location = LocationRepository.findById(locationId).orElseThrow(() -> new ResourceNotFoundException("The location attributed to this id hasn't been found: " + locationId) );
    location.setAddress(locationDto.getAddress());
    location.setCity(locationDto.getCity());
    location.setLocation_name(locationDto.getLocation_name());
    location.setSchedule_id(locationDto.getSchedule_id());
    location.setSeason_id(locationDto.getSeason_id());

    LocationIdentity updatedLocation = LocationRepository.save(location);
    return LocationMapper.maptoLocationDto(updatedLocation);
}

public void deleteLocation(int locationId){
    LocationRepository.findById(locationId).orElseThrow(() -> new ResourceNotFoundException("The location attributed to this id hasn't been found: " + locationId) );
    LocationRepository.deleteById(locationId);
}

public List<LocationDto> getAllLocations(){
    List<LocationIdentity> locations = LocationRepository.findAll();
    return locations.stream().map((location) -> LocationMapper.maptoLocationDto(location)).collect(Collectors.toList());
}
}