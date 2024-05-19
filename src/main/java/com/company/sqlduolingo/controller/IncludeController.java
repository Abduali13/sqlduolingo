package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.IncludeDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.IncludeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "include")
public class IncludeController {

    private final IncludeService includeService;

    @PostMapping
    public ResponseDto<IncludeDto> create(@RequestBody IncludeDto dto){
        return this.includeService.create(dto);
    }

    @GetMapping
    public ResponseDto<IncludeDto> get(@RequestParam(value = "id") Integer includeId){
        return this.includeService.get(includeId);
    }

    @PutMapping
    public ResponseDto<IncludeDto> update(@RequestParam(value = "id") Integer includeId, @RequestBody IncludeDto dto){
        return this.includeService.update(includeId, dto);
    }

    @DeleteMapping
    public ResponseDto<IncludeDto> delete(@RequestParam(value = "id") Integer includeId){
        return this.includeService.delete(includeId);
    }
}
