package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.IncludeDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.TranslateGameDto;
import com.company.sqlduolingo.service.IncludeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/include")
public class IncludeController {

    private final IncludeService includeService;

    @PostMapping("/courseIncludeExercise/{courseId}/{exerciseId}")
    public ResponseEntity<ResponseDto<IncludeDto>> courseIncludeExercise(@PathVariable Integer courseId, @PathVariable Integer exerciseId){
        return convertStatusCodeByData(this.includeService.courseIncludesExercise(courseId, exerciseId));
    }

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
