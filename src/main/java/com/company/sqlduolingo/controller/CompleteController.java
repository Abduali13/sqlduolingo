package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.CompleteDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.CompleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/complete")
public class CompleteController {

    private final CompleteService completeService;


    @PostMapping("/usersCompleteExercise/{ssn}/{exerciseId}")
    public ResponseEntity<ResponseDto<CompleteDto>> usersCompleteExercise(@PathVariable Integer ssn, @PathVariable Integer exerciseId){
        return convertStatusCodeByData(this.completeService.usersCompleteExercise(ssn, exerciseId));
    }


    @PostMapping
    public ResponseEntity<ResponseDto<CompleteDto>> create(@RequestBody CompleteDto dto){
        return convertStatusCodeByData(this.completeService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<CompleteDto>> get(@RequestParam(value = "id") Integer completeId){
        return convertStatusCodeByData(this.completeService.get(completeId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<CompleteDto>> update(@RequestParam(value = "id") Integer completeId, @RequestBody CompleteDto dto){
        return convertStatusCodeByData(this.completeService.update(completeId));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<CompleteDto>> delete(@RequestParam(value = "id") Integer completeId){
        return convertStatusCodeByData(this.completeService.delete(completeId));
    }



}
