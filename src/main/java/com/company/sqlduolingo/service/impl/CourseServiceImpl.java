package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.CourseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Course;
import com.company.sqlduolingo.repository.CourseRepository;
import com.company.sqlduolingo.service.CourseService;
import com.company.sqlduolingo.service.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    @Override
    public ResponseDto<CourseDto> create(CourseDto dto) {
        try {
            Course entity = this.courseMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<CourseDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.courseMapper.toDto(
                                    this.courseRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<CourseDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<CourseDto> get(Integer courseId) {
        Optional<Course> optional = this.courseRepository.findCourseByCourseIdAndDeletedAtIsNull(courseId);
        if (optional.isEmpty()) {
            return ResponseDto.<CourseDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", courseId))
                    .build();
        }
        return ResponseDto.<CourseDto>builder()
                .success(true)
                .message("OK")
                .content(this.courseMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<CourseDto> update(Integer courseId, CourseDto dto) {
        Optional<Course> optional = this.courseRepository.findCourseByCourseIdAndDeletedAtIsNull(courseId);
        if (optional.isEmpty()) {
            return ResponseDto.<CourseDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", courseId))
                    .build();
        }
        return ResponseDto.<CourseDto>builder()
                .success(true)
                .message("OK")
                .content(this.courseMapper.toDto(
                                this.courseRepository.save(
                                        this.courseMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<CourseDto> delete(Integer courseId) {
        Optional<Course> optional = this.courseRepository.findCourseByCourseIdAndDeletedAtIsNull(courseId);
        if (optional.isEmpty()) {
            return ResponseDto.<CourseDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", courseId))
                    .build();
        }
        Course course = optional.get();
        course.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<CourseDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.courseMapper.toDto(
                                this.courseRepository.save(course))
                ).build();
    }
}
