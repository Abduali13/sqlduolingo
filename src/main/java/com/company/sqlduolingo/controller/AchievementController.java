package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.AchievementDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/achievement")
public class AchievementController {

    private final AchievementService achievementService;

    @PostMapping
    public ResponseDto<AchievementDto> create(@RequestBody AchievementDto dto){
        return this.achievementService.create(dto);
    }

    @GetMapping
    public ResponseDto<AchievementDto> get(@RequestParam(value = "id") Integer achievementId){
        return this.achievementService.get(achievementId);
    }

    @PutMapping
    public ResponseDto<AchievementDto> update(@RequestParam(value = "id") Integer achievementId,@RequestBody AchievementDto dto){
        return this.achievementService.update(achievementId,dto);
    }

    @DeleteMapping
    public ResponseDto<AchievementDto> delete(@RequestParam(value = "id") Integer achievementId){
        return this.achievementService.delete(achievementId);
    }


}
