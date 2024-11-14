package com.soen342.demo.ServiceInterfaces;

import java.util.List;

import com.soen342.demo.dto.SeasonDto;

public interface SeasonService {
    SeasonDto createSeason(SeasonDto seasonDto);
    SeasonDto getSeasonbyId(int id);
    SeasonDto updateSeason(int seasonId, SeasonDto seasonDto);
    void deleteSeason(int seasonId);
    List<SeasonDto> getAllSeasons();
}
