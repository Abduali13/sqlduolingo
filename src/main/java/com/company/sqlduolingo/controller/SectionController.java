package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.SectionDto;
import com.company.sqlduolingo.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/section")
public class SectionController {

    private final SectionService sectionService;

    @PostMapping
    public ResponseDto<SectionDto> create(@RequestBody SectionDto dto){
        return this.sectionService.create(dto);
    }

    @GetMapping
    public ResponseDto<SectionDto> get(@RequestParam(value = "id") Integer sectionId){
        return this.sectionService.get(sectionId);
    }

    @PutMapping
    public ResponseDto<SectionDto> update(@RequestParam(value = "id") Integer sectionId, @RequestBody SectionDto dto){
        return this.sectionService.update(sectionId, dto);
    }

    @DeleteMapping
    public ResponseDto<SectionDto> delete(@RequestParam(value = "id") Integer sectionId){
        return this.sectionService.delete(sectionId);
    }

}
