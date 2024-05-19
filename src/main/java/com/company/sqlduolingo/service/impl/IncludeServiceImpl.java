package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.IncludeDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Course;
import com.company.sqlduolingo.entity.Exercise;
import com.company.sqlduolingo.entity.Include;
import com.company.sqlduolingo.repository.CourseRepository;
import com.company.sqlduolingo.repository.ExerciseRepository;
import com.company.sqlduolingo.repository.IncludeRepository;
import com.company.sqlduolingo.service.IncludeService;
import com.company.sqlduolingo.service.mapper.IncludeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class IncludeServiceImpl implements IncludeService {

    private final CourseRepository courseRepository;
    private final ExerciseRepository exerciseRepository;
    private final IncludeRepository includeRepository;
    private final IncludeMapper includeMapper;


    @Override
    public ResponseDto<IncludeDto> courseIncludesExercise(Integer courseId, Integer exerciseId) {
        Optional<Course> optionalCourse = this.courseRepository.findCourseByCourseIdAndDeletedAtIsNull(courseId);
        if (optionalCourse.isEmpty()) {
            return ResponseDto.<IncludeDto>builder()
                    .code(-1)
                    .message("Course is not found")
                    .build();
        }
        Optional<Exercise> optionalExercise = this.exerciseRepository.findExerciseByExerciseIdAndDeletedAtIsNull(exerciseId);
        if (optionalExercise.isEmpty()) {
            return ResponseDto.<IncludeDto>builder()
                    .code(-1)
                    .message("Exercises are not found").build();
        }

        Include include = new Include();
        include.setCourseId(optionalCourse.get().getCourseId());
        include.setCourse(optionalCourse.get());
        include.setExerciseId(optionalExercise.get().getExerciseId());
        include.setExercise(optionalExercise.get());
        return ResponseDto.<IncludeDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.includeMapper.toDto(
                                this.includeRepository.save(include)
                        )
                )
                .build();
    }


    @Override
    public ResponseDto<IncludeDto> create(IncludeDto dto) {
        return null;
    }

    @Override
    public ResponseDto<IncludeDto> get(Integer includeId) {
        return null;
    }

    @Override
    public ResponseDto<IncludeDto> update(Integer includeId, IncludeDto dto) {
        return null;
    }

    @Override
    public ResponseDto<IncludeDto> delete(Integer includeId) {
        return null;
    }


}
