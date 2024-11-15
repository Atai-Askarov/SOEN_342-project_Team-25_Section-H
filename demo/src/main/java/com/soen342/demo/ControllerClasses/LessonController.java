package com.soen342.demo.ControllerClasses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.soen342.demo.dto.LessonDto;
import com.soen342.demo.ServiceInterfaces.LessonService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonDto> createLesson(@RequestBody LessonDto lessonDto) {
        LessonDto savedLesson = lessonService.createLesson(lessonDto);
        return new ResponseEntity<>(savedLesson, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<LessonDto> getLessonById(@PathVariable("id") int lessonId) {
        LessonDto lessonDto = lessonService.getLessonById(lessonId);
        return new ResponseEntity<>(lessonDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LessonDto>> getAllLessons() {
        List<LessonDto> lessons = lessonService.getAllLessons();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
}
