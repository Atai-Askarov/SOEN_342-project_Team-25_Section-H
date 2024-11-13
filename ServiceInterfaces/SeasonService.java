package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.SeasonDto;

public interface SeasonService {
    SeasonDto createSeason(SeasonDto seasonDto);
    SeasonDto getSeasonbyId(int id);
}
