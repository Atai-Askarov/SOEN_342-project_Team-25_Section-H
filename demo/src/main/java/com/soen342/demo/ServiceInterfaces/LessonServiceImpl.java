package com.soen342.demo.ServiceInterfaces;

import org.springframework.stereotype.Service;
import com.soen342.demo.IdentityClasses.LessonIdentity;
import com.soen342.demo.MapperClasses.LessonMapper;
import com.soen342.demo.RepositoryClasses.LessonRepository;
import com.soen342.demo.dto.LessonDto;
import com.soen342.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;

    @Override
    public LessonDto createLesson(LessonDto lessonDto) {
        LessonIdentity lesson = LessonMapper.mapToLessonIdentity(lessonDto);
        LessonIdentity savedLesson = lessonRepository.save(lesson);
        return LessonMapper.mapToLessonDto(savedLesson);
    }

    @Override
    public LessonDto getLessonById(int id) {
        LessonIdentity lesson = lessonRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Lesson not found with the given ID"));
        return LessonMapper.mapToLessonDto(lesson);
    }
}
