package com.soen342.demo.MapperClasses;

import com.soen342.demo.IdentityClasses.LessonIdentity;
import com.soen342.demo.dto.LessonDto;

public class LessonMapper {
    public static LessonDto mapToLessonDto(LessonIdentity lesson){
        return new LessonDto(
            lesson.getLessonId(),
            lesson.getLocationId(),
            lesson.getTimeslotId(),
            lesson.getMode(),
            lesson.getStatus(),
            lesson.getCapacity(),
            lesson.getLessonName()
        );
    }

    public static LessonIdentity mapToLessonIdentity(LessonDto lessonDto){
        return new LessonIdentity(
            lessonDto.getLessonId(),
            lessonDto.getLocationId(),
            lessonDto.getTimeslotId(),
            lessonDto.getMode(),
            lessonDto.getStatus(),
            lessonDto.getCapacity(),
            lessonDto.getLessonName()
        );
    }
}
