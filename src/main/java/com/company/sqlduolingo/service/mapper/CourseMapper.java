package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.CourseDto;
import com.company.sqlduolingo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    @Lazy
    @Autowired
    private IncludeMapper includeMapper;

    @Lazy
    @Autowired
    private KeywordMapper keywordMapper;

    @Lazy
    @Autowired
    private ReferenceMapper referenceMapper;

    @Lazy
    @Autowired
    private RegisterMapper registerMapper;

    @Lazy
    @Autowired
    private SectionMapper sectionMapper;

    public Course toEntity(CourseDto dto){
        return Course.builder()
                .courseName(dto.getCourseName())
                .description(dto.getDescription())
                .level(dto.getLevel())
                .build();
    }

    public CourseDto toDto(Course course){
        return CourseDto.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .level(course.getLevel())
                .includes(course.getIncludes() != null ? course.getIncludes().stream().map(this.includeMapper::toDto).toList() : null )
                .keywords(course.getKeywords() != null ? course.getKeywords().stream().map(this.keywordMapper::toDto).toList() : null)
                .references(course.getReferences() != null ? course.getReferences().stream().map(this.referenceMapper::toDto).toList() : null)
                .registers(course.getRegisters() != null ? course.getRegisters().stream().map(this.registerMapper::toDto).toList() : null)
                .sections(course.getSections() != null ? course.getSections().stream().map(this.sectionMapper::toDto).toList() : null)
                .createdAt(course.getCreatedAt())
                .updatedAt(course.getUpdatedAt())
                .deletedAt(course.getDeletedAt())
                .build();
    }

    public Course update(Course course, CourseDto dto){
        if (dto.getCourseName()!=null) {
            course.setCourseName(course.getCourseName());
        }
        if (dto.getDescription() != null){
            course.setDescription(dto.getDescription());
        }
        return course;
    }

}
