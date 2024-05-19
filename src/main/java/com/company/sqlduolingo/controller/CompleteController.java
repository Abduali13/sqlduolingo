package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.CompleteDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.CompleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/complete")
public class CompleteController {

    private final CompleteService completeService;


    @PostMapping("/usersCompleteExercise/{ssn}/{exerciseId}")
    public ResponseDto<CompleteDto> usersCompleteExercise(@PathVariable Integer ssn,@PathVariable Integer exerciseId){
        return this.completeService.usersCompleteExercise(ssn, exerciseId);
    }


    @PostMapping
    public ResponseDto<CompleteDto> create(@RequestBody CompleteDto dto){
        return this.completeService.create(dto);
    }

    @GetMapping
    public ResponseDto<CompleteDto> get(@RequestParam(value = "id") Integer completeId){
        return this.completeService.get(completeId);
    }

    @PutMapping
    public ResponseDto<CompleteDto> update(@RequestParam(value = "id") Integer completeId, @RequestBody CompleteDto dto){
        return this.completeService.update(completeId);
    }

    @DeleteMapping
    public ResponseDto<CompleteDto> delete(@RequestParam(value = "id") Integer completeId){
        return this.completeService.delete(completeId);
    }



}
