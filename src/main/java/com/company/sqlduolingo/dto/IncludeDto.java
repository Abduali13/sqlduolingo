package com.company.sqlduolingo.dto;


import com.company.sqlduolingo.entity.template.AbsEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncludeDto {


    private Integer includeId;

    private Integer courseId;

    private Integer exerciseId;

    private CourseDto course;

    private ExerciseDto exercise;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
