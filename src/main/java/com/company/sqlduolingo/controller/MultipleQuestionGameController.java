package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.MultipleQuestionGameDto;
import com.company.sqlduolingo.service.MultipleQuestionGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/test-game")
public class MultipleQuestionGameController {

    private final MultipleQuestionGameService multipleQuestionGameService;

    @PostMapping
    public ResponseDto<MultipleQuestionGameDto> create(@RequestBody MultipleQuestionGameDto dto){
        return this.multipleQuestionGameService.create(dto);
    }

    @GetMapping
    public ResponseDto<MultipleQuestionGameDto> get(@RequestParam(value = "id") Integer worksheetId){
        return this.multipleQuestionGameService.get(worksheetId);
    }

    @PutMapping
    public ResponseDto<MultipleQuestionGameDto> update(@RequestParam(value = "id") Integer worksheetId, @RequestBody MultipleQuestionGameDto dto){
        return this.multipleQuestionGameService.update(worksheetId, dto);
    }

    @DeleteMapping
    public ResponseDto<MultipleQuestionGameDto> delete(@RequestParam(value = "id") Integer worksheetId){
        return this.multipleQuestionGameService.delete(worksheetId);
    }

}
