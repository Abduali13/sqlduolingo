package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.AchievementDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AchievementService {

    ResponseDto<AchievementDto> create(AchievementDto dto);

    ResponseDto<AchievementDto> get(Integer dto);

    ResponseDto<AchievementDto> update(Integer achievementId, AchievementDto dto);

    ResponseDto<AchievementDto> delete(Integer dto);
}
