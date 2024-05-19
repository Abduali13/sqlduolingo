package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.StatisticsDto;
import com.company.sqlduolingo.dto.TranslateDto;
import com.company.sqlduolingo.service.StatisticsService;
import com.company.sqlduolingo.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/translate")
public class TranslateController {

    private final TranslateService translateService;

    @PostMapping
    public ResponseDto<TranslateDto> create(@RequestBody TranslateDto dto){
        return this.translateService.create(dto);
    }

    @GetMapping
    public ResponseDto<TranslateDto> get(@RequestParam(value = "id") Integer translateId){
        return this.translateService.get(translateId);
    }

    @PutMapping
    public ResponseDto<TranslateDto> update(@RequestParam(value = "id") Integer translateId, @RequestBody TranslateDto dto){
        return this.translateService.update(translateId, dto);
    }

    @DeleteMapping
    public ResponseDto<TranslateDto> delete(@RequestParam(value = "id") Integer translateId){
        return this.translateService.delete(translateId);
    }
}
