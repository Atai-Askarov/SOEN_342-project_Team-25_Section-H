package com.soen342.demo.ServiceInterfaces;

import com.soen342.demo.IdentityClasses.LessonIdentity;
import com.soen342.demo.MapperClasses.LessonMapper;
import com.soen342.demo.RepositoryClasses.LessonRepository;
import com.soen342.demo.dto.LessonDto;
import com.soen342.demo.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<LessonDto> getAllLessons() {
        return lessonRepository.findAll()
                .stream()
                .map(LessonMapper::mapToLessonDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLessonById(int id) {
        if (!lessonRepository.existsById(id)) {
            throw new ResourceNotFoundException("Lesson not found with the given ID");
        }
        lessonRepository.deleteById(id);
    }
}
