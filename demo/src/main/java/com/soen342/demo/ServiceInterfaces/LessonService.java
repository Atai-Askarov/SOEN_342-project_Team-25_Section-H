package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.LessonDto;

public interface LessonService {
    LessonDto createLesson(LessonDto lessonDto);
    LessonDto getLessonById(int id);
}
