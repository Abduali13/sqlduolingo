package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.AchievementDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.AchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/achievement")
public class AchievementController {

    private final AchievementService achievementService;

    @PostMapping
    public ResponseEntity<ResponseDto<AchievementDto>> create(@RequestBody AchievementDto dto){
        return convertStatusCodeByData(this.achievementService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<AchievementDto>> get(@RequestParam(value = "id") Integer achievementId){
        return convertStatusCodeByData(this.achievementService.get(achievementId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<AchievementDto>> update(@RequestParam(value = "id") Integer achievementId,@RequestBody AchievementDto dto){
        return convertStatusCodeByData(this.achievementService.update(achievementId,dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<AchievementDto>> delete(@RequestParam(value = "id") Integer achievementId){
        return convertStatusCodeByData(this.achievementService.delete(achievementId));
    }


}
