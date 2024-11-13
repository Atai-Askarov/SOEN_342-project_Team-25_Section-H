package com.soen342.demo.ControllerClasses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soen342.demo.ServiceInterfaces.LocationService;
import com.soen342.demo.dto.LocationDto;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/api/location")
public class LocationController {
    private LocationService LocationService;
    //Build POST Location REST API 
    @PostMapping
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto LocationDto){
        LocationDto savedLocation = LocationService.createLocation(LocationDto);
        return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
    }

    // Build GET Location REST API
    @GetMapping("{id}")
    public ResponseEntity<LocationDto> getLocationbyId(@PathVariable("id") int LocationId){
        LocationDto LocationDto = LocationService.getLocationbyId(LocationId);
        return new ResponseEntity<>(LocationDto, HttpStatus.OK);
    }

}
