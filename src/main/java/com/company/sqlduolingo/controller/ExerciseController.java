package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ExerciseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    public ResponseDto<ExerciseDto> create(@RequestBody ExerciseDto dto){
        return this.exerciseService.create(dto);
    }

    @GetMapping
    public ResponseDto<ExerciseDto> get(@RequestParam(value = "id") Integer exerciseId){
        return this.exerciseService.get(exerciseId);
    }

    @PutMapping
    public ResponseDto<ExerciseDto> update(@RequestParam(value = "id") Integer exerciseId, @RequestBody ExerciseDto dto){
        return this.exerciseService.update(exerciseId, dto);
    }

    @DeleteMapping
    public ResponseDto<ExerciseDto> delete(@RequestParam(value = "id") Integer exerciseId){
        return this.exerciseService.delete(exerciseId);
    }


}
