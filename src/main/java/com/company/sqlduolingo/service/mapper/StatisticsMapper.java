package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.StatisticsDto;
import com.company.sqlduolingo.entity.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StatisticsMapper {

    private final AchievementMapper achievementMapper;
    private final CourseMapper courseMapper;
    private final UsersMapper usersMapper;
    private final MistakeMapper mistakeMapper;

    public Statistics toEntity(StatisticsDto dto){
        return Statistics.builder()
                .score(dto.getScore()).build();
    }

    public StatisticsDto toDto(Statistics statistics){
        return StatisticsDto.builder()
                .statisticsId(statistics.getStatisticsId())
                .score(statistics.getScore())
                .courseId(statistics.getCourseId())
                .achievements(statistics.getAchievements() != null ? statistics.getAchievements().stream().map(this.achievementMapper::toDto).toList() : null)
                .courses(statistics.getCourses() != null ? statistics.getCourses().stream().map(this.courseMapper::toDto).toList() : null)
                .users(statistics.getUsers() != null ? statistics.getUsers().stream().map(this.usersMapper::toDto).toList() : null)
                .mistakes(statistics.getMistakes() != null ? statistics.getMistakes().stream().map(this.mistakeMapper::toDto).toList() : null)
                .createdAt(statistics.getCreatedAt())
                .updatedAt(statistics.getUpdatedAt())
                .deletedAt(statistics.getDeletedAt())
                .build();
    }

    public  Statistics update(Statistics statistics, StatisticsDto dto){
        if (dto.getScore() != null) {
            statistics.setScore(dto.getScore());
        }
        return statistics;
    }
}
