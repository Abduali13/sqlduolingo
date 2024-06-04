package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.CourseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Course;
import com.company.sqlduolingo.exception.ResourceNotFoundException;
import com.company.sqlduolingo.repository.CourseRepository;
import com.company.sqlduolingo.service.CourseService;
import com.company.sqlduolingo.service.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
                    .message(String.format("Course error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<CourseDto> get(Integer courseId) {
        try {
            Course course = this.courseRepository.findCourseByCourseIdAndDeletedAtIsNull(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", courseId));

            return ResponseDto.<CourseDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.courseMapper.toDto(course)).build();
        }
        catch (Exception e){
            return ResponseDto.<CourseDto>builder()
                    .code(-3)
                    .message(e.getMessage())
                    .build();
        }

    }

    @Override
    public ResponseDto<CourseDto> update(Integer courseId, CourseDto dto) {
        try {
            Course course = this.courseRepository.findCourseByCourseIdAndDeletedAtIsNull(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", courseId));

            return ResponseDto.<CourseDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.courseMapper.toDto(
                                    this.courseRepository.save(
                                            this.courseMapper.update(
                                                    course, dto
                                            )
                                    )
                            )
                    )
                    .build();
        }

        catch (Exception e){
            return ResponseDto.<CourseDto>builder()
                    .code(-3)
                    .message(e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<CourseDto> delete(Integer courseId) {
        try {
            Course course = this.courseRepository.findCourseByCourseIdAndDeletedAtIsNull(courseId).orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", courseId));

            course.setDeletedAt(LocalDateTime.now());
            return ResponseDto.<CourseDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.courseMapper.toDto(
                                    this.courseRepository.save(course))
                    ).build();
        }

        catch (Exception e){
            return ResponseDto.<CourseDto>builder()
                    .code(-3)
                    .message(e.getMessage())
                    .build();
        }

    }
}
