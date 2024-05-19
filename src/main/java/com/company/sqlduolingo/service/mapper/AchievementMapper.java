package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.AchievementDto;
import com.company.sqlduolingo.entity.Achievement;
import org.springframework.stereotype.Component;

@Component
public class AchievementMapper {

    public Achievement toEntity(AchievementDto dto){
        return Achievement.builder()
                .achievement(dto.getAchievement())
                .build();
    }

    public AchievementDto toDto(Achievement achievement){
        return AchievementDto.builder()
                .achievementId(achievement.getAchievementId())
                .achievement(achievement.getAchievement())
                .createdAt(achievement.getCreatedAt())
                .updatedAt(achievement.getUpdatedAt())
                .deletedAt(achievement.getDeletedAt())
                .statisticsId(achievement.getStatisticsId())
                .build();
    }

    public Achievement update(Achievement achievement, AchievementDto achievementDto){
        if (achievementDto.getAchievement() != null) {
            achievement.setAchievement(achievementDto.getAchievement());
        }
        return achievement;
    }
}
