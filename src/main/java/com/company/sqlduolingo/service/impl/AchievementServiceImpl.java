package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.AchievementDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Achievement;
import com.company.sqlduolingo.repository.AchievementRepository;
import com.company.sqlduolingo.service.AchievementService;
import com.company.sqlduolingo.service.mapper.AchievementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AchievementServiceImpl implements AchievementService {

    private final AchievementRepository achievementRepository;
    private final AchievementMapper achievementMapper;

    @Override
    public ResponseDto<AchievementDto> create(AchievementDto dto) {
        try {
            Achievement entity = this.achievementMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<AchievementDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.achievementMapper.toDto(
                                    this.achievementRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<AchievementDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<AchievementDto> get(Integer achievementId) {
        Optional<Achievement> optional = this.achievementRepository.findAchievementByAchievementIdAndDeletedAtIsNull(achievementId);
        if (optional.isEmpty()) {
            return ResponseDto.<AchievementDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", achievementId))
                    .build();
        }
        return ResponseDto.<AchievementDto>builder()
                .success(true)
                .message("OK")
                .content(this.achievementMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<AchievementDto> update(Integer achievementId, AchievementDto dto) {
        Optional<Achievement> optional = this.achievementRepository.findAchievementByAchievementIdAndDeletedAtIsNull(achievementId);
        if (optional.isEmpty()) {
            return ResponseDto.<AchievementDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", achievementId))
                    .build();
        }
        return ResponseDto.<AchievementDto>builder()
                .success(true)
                .message("OK")
                .content(this.achievementMapper.toDto(
                                this.achievementRepository.save(
                                        this.achievementMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();

    }

    @Override
    public ResponseDto<AchievementDto> delete(Integer achievementId) {
        Optional<Achievement> optional = this.achievementRepository.findAchievementByAchievementIdAndDeletedAtIsNull(achievementId);
        if (optional.isEmpty()) {
            return ResponseDto.<AchievementDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", achievementId))
                    .build();
        }
        Achievement achievement = optional.get();
        achievement.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<AchievementDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.achievementMapper.toDto(
                                this.achievementRepository.save(achievement))
                ).build();
    }
}
