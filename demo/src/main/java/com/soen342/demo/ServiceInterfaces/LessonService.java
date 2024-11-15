package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.dto.LessonDto;
import java.util.List;

public interface LessonService {
    LessonDto createLesson(LessonDto lessonDto);
    LessonDto getLessonById(int id);
    List<LessonDto> getAllLessons();
    void deleteLessonById(int id);
}
