package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.SectionDto;
import com.company.sqlduolingo.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/section")
public class SectionController {

    private final SectionService sectionService;

    @PostMapping
    public ResponseEntity<ResponseDto<SectionDto>> create(@RequestBody SectionDto dto){
        return convertStatusCodeByData(this.sectionService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<SectionDto>> get(@RequestParam(value = "id") Integer sectionId){
        return convertStatusCodeByData(this.sectionService.get(sectionId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<SectionDto>> update(@RequestParam(value = "id") Integer sectionId, @RequestBody SectionDto dto){
        return convertStatusCodeByData(this.sectionService.update(sectionId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<SectionDto>> delete(@RequestParam(value = "id") Integer sectionId){
        return convertStatusCodeByData(this.sectionService.delete(sectionId));
    }

}
