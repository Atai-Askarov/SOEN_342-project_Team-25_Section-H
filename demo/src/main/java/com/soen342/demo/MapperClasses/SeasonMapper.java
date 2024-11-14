package com.soen342.demo.MapperClasses;

import com.soen342.demo.IdentityClasses.SeasonIdentity;
import com.soen342.demo.dto.SeasonDto;

public class SeasonMapper {
    public static SeasonDto maptoSeasonDto(SeasonIdentity Season){
        return new SeasonDto(
            Season.getSeason_id(),
            Season.getStart_date(),
            Season.getEnd_date(),
            Season.getTimeslot_id()
        );

    }

    public static SeasonIdentity maptoSeasonIdentity(SeasonDto Season){
        return new SeasonIdentity(
            Season.getSeason_id(),
            Season.getStart_date(),
            Season.getEnd_date(),
            Season.getTimeslot_id()
        );
    }
}
