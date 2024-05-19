package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ReferenceDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.ReferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "reference")
public class ReferenceController {

    private final ReferenceService referenceService;

    @PostMapping
    public ResponseDto<ReferenceDto> create(@RequestBody ReferenceDto dto){
        return this.referenceService.create(dto);
    }

    @GetMapping
    public ResponseDto<ReferenceDto> get(@RequestParam(value = "id") Integer referenceId){
        return this.referenceService.get(referenceId);
    }

    @PutMapping
    public ResponseDto<ReferenceDto> update(@RequestParam(value = "id") Integer referenceId, @RequestBody ReferenceDto dto){
        return this.referenceService.update(referenceId, dto);
    }

    @DeleteMapping
    public ResponseDto<ReferenceDto> delete(@RequestParam(value = "id") Integer referenceId){
        return this.referenceService.delete(referenceId);
    }
}
