package com.soen342.demo.ServiceInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soen342.demo.IdentityClasses.SeasonIdentity;
import com.soen342.demo.MapperClasses.SeasonMapper;
import com.soen342.demo.RepositoryClasses.SeasonRepository;
import com.soen342.demo.dto.SeasonDto;
import com.soen342.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SeasonServiceImpl implements SeasonService{
    @Autowired
    private SeasonRepository seasonRepository;

    public SeasonDto createSeason(SeasonDto seasonDto){
        SeasonIdentity season= SeasonMapper.maptoSeasonIdentity(seasonDto);
        SeasonIdentity savedSeason = seasonRepository.save(season);

        return SeasonMapper.maptoSeasonDto(savedSeason);
    
    };
    public SeasonDto getSeasonbyId(int id){
        SeasonIdentity Season = seasonRepository.findById(id)
                                        .orElseThrow(() -> 
                                        new ResourceNotFoundException("Season does not exist with the given ID"));

        return SeasonMapper.maptoSeasonDto(Season);

    };
}
