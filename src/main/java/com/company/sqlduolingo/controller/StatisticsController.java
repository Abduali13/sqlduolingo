package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.SectionDto;
import com.company.sqlduolingo.dto.StatisticsDto;
import com.company.sqlduolingo.service.SectionService;
import com.company.sqlduolingo.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @PostMapping
    public ResponseDto<StatisticsDto> create(@RequestBody StatisticsDto dto){
        return this.statisticsService.create(dto);
    }

    @GetMapping
    public ResponseDto<StatisticsDto> get(@RequestParam(value = "id") Integer statisticsId){
        return this.statisticsService.get(statisticsId);
    }

    @PutMapping
    public ResponseDto<StatisticsDto> update(@RequestParam(value = "id") Integer statisticsId, @RequestBody StatisticsDto dto){
        return this.statisticsService.update(statisticsId, dto);
    }

    @DeleteMapping
    public ResponseDto<StatisticsDto> delete(@RequestParam(value = "id") Integer statisticsId){
        return this.statisticsService.delete(statisticsId);
    }
}
