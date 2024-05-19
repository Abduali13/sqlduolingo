package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.MistakeDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.MistakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/mistake")
public class MistakeController {

    private final MistakeService mistakeService;

    @PostMapping
    public ResponseDto<MistakeDto> create(@RequestBody MistakeDto dto){
        return this.mistakeService.create(dto);
    }

    @GetMapping
    public ResponseDto<MistakeDto> get(@RequestParam(value = "id") Integer mistakeId){
        return this.mistakeService.get(mistakeId);
    }

    @PutMapping
    public ResponseDto<MistakeDto> update(@RequestParam(value = "id") Integer mistakeId, @RequestBody MistakeDto dto){
        return this.mistakeService.update(mistakeId, dto);
    }

    @DeleteMapping
    public ResponseDto<MistakeDto> delete(@RequestParam(value = "id") Integer mistakeId){
        return this.mistakeService.delete(mistakeId);
    }
}
