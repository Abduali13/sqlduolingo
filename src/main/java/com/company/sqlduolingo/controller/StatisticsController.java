package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.SectionDto;
import com.company.sqlduolingo.dto.StatisticsDto;
import com.company.sqlduolingo.service.SectionService;
import com.company.sqlduolingo.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @PostMapping
    public ResponseEntity<ResponseDto<StatisticsDto>> create(@RequestBody StatisticsDto dto){
        return convertStatusCodeByData(this.statisticsService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<StatisticsDto>> get(@RequestParam(value = "id") Integer statisticsId){
        return convertStatusCodeByData(this.statisticsService.get(statisticsId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<StatisticsDto>> update(@RequestParam(value = "id") Integer statisticsId, @RequestBody StatisticsDto dto){
        return convertStatusCodeByData(this.statisticsService.update(statisticsId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<StatisticsDto>> delete(@RequestParam(value = "id") Integer statisticsId){
        return convertStatusCodeByData(this.statisticsService.delete(statisticsId));
    }
}
