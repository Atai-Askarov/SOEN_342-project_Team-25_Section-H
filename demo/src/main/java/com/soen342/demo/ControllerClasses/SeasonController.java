package com.soen342.demo.ControllerClasses;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soen342.demo.ServiceInterfaces.SeasonService;
import com.soen342.demo.dto.SeasonDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/season")
public class SeasonController {
    private SeasonService seasonService;
    //Build POST Season REST API 
    @PostMapping
    public ResponseEntity<SeasonDto> createSeason(@RequestBody SeasonDto seasonDto){
        SeasonDto savedSeason = seasonService.createSeason(seasonDto);
        return new ResponseEntity<>(savedSeason, HttpStatus.CREATED);
    }

    // Build GET Season REST API
    @GetMapping("{id}")
    public ResponseEntity<SeasonDto> getSeasonbyId(@PathVariable("id") int seasonId){
        SeasonDto seasonDto = seasonService.getSeasonbyId(seasonId);
        return new ResponseEntity<>(seasonDto, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<SeasonDto> updateSeason(@PathVariable("id") int seasonId, 
                                                @RequestBody SeasonDto updateSeason){
        SeasonDto seasonDto = seasonService.updateSeason(seasonId, updateSeason);
        return new ResponseEntity<>(seasonDto, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSeason(@PathVariable("id") int seasonId){
        seasonService.deleteSeason(seasonId);
        return new ResponseEntity<>("Season has been deleted successfully", HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<SeasonDto>> getAllSeasons(){
        List<SeasonDto> seasons = seasonService.getAllSeasons();
        return new ResponseEntity<>(seasons, HttpStatus.OK);
    }
    }
