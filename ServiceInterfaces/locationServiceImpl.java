package com.soen342.demo.ServiceInterfaces;

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
}
