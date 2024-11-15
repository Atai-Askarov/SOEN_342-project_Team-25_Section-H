package com.soen342.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonDto {
    private int lessonId;
    private int locationId;
    private int timeslotId;
    private String mode;
    private String status;
    private int capacity;
    private String lessonName;
}
