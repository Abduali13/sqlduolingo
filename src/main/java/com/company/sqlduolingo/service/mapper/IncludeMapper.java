package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.IncludeDto;
import com.company.sqlduolingo.entity.Include;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class IncludeMapper {

    @Lazy
    @Autowired
    private CourseMapper courseMapper;

    @Lazy
    @Autowired
    private ExerciseMapper exerciseMapper;

    public Include toEntity(IncludeDto dto){
        return Include.builder().build();
    }

    public IncludeDto toDto(Include include) {
        return IncludeDto.builder()
                .includeId(include.getIncludeId())
                .courseId(include.getCourseId())
                .course(this.courseMapper.toDto(include.getCourse()))
                .exercise(this.exerciseMapper.toDto(include.getExercise()))
                .createdAt(include.getCreatedAt())
                .updatedAt(include.getUpdatedAt())
                .deletedAt(include.getDeletedAt())
                .build();
    }

    public Include update(Include include, IncludeDto dto){
        return include;
    }
}
