package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.SectionDto;
import com.company.sqlduolingo.entity.Section;
import org.springframework.stereotype.Component;

@Component
public class SectionMapper {

    public Section toEntity(SectionDto dto){
        return Section.builder()
                .section(dto.getSection())
                .build();
    }

    public SectionDto toDto(Section section) {
        return SectionDto.builder()
                .sectionId(section.getSectionId())
                .courseId(section.getCourseId())
                .section(section.getSection())
                .createdAt(section.getCreatedAt())
                .updatedAt(section.getUpdatedAt())
                .deletedAt(section.getDeletedAt())
                .build();
    }

    public Section update(Section section, SectionDto dto){
        if (dto.getSection() != null){
            section.setSection(dto.getSection());
        }
        return section;
    }

}
