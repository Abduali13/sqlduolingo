package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ExerciseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    public ResponseEntity<ResponseDto<ExerciseDto>> create(@RequestBody ExerciseDto dto){
        return convertStatusCodeByData(this.exerciseService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<ExerciseDto>> get(@RequestParam(value = "id") Integer exerciseId){
        return convertStatusCodeByData(this.exerciseService.get(exerciseId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<ExerciseDto>> update(@RequestParam(value = "id") Integer exerciseId, @RequestBody ExerciseDto dto){
        return convertStatusCodeByData(this.exerciseService.update(exerciseId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<ExerciseDto>> delete(@RequestParam(value = "id") Integer exerciseId){
        return convertStatusCodeByData(this.exerciseService.delete(exerciseId));
    }


}
