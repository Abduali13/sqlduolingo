package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.MistakeDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.MistakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/mistake")
public class MistakeController {

    private final MistakeService mistakeService;

    @PostMapping
    public ResponseEntity<ResponseDto<MistakeDto>> create(@RequestBody MistakeDto dto){
        return convertStatusCodeByData(this.mistakeService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<MistakeDto>> get(@RequestParam(value = "id") Integer mistakeId){
        return convertStatusCodeByData(this.mistakeService.get(mistakeId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<MistakeDto>> update(@RequestParam(value = "id") Integer mistakeId, @RequestBody MistakeDto dto){
        return convertStatusCodeByData(this.mistakeService.update(mistakeId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<MistakeDto>> delete(@RequestParam(value = "id") Integer mistakeId){
        return convertStatusCodeByData(this.mistakeService.delete(mistakeId));
    }
}
