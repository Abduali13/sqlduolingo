package com.company.sqlduolingo.dto;



import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDto {

    private Integer statisticsId;

    private Integer score;

    private Integer courseId;

    private List<CourseDto> courses;

    private List<UsersDto> users;

    private List<AchievementDto> achievements;

    private List<MistakeDto> mistakes;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
