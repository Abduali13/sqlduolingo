package com.company.sqlduolingo.dto;


import com.company.sqlduolingo.entity.enums.Level;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Integer courseId;

    private String courseName;
    private String description;

    @Enumerated(EnumType.STRING)
    private Level level;

    private Integer statisticsId;

    private Integer registerId;

    private List<RegisterDto> registers;

    private StatisticsDto statistics;

    private List<IncludeDto> includes;

    private List<SectionDto> sections;

    private List<KeywordDto> keywords;

    private List<ReferenceDto> references;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
