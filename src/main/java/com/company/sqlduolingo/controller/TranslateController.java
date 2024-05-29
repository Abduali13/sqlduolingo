package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.TranslateGameDto;
import com.company.sqlduolingo.service.TranslateGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/translate-game")
public class TranslateController {

    private final TranslateGameService translateGameService;

    @PostMapping
    public ResponseDto<TranslateGameDto> create(@RequestBody TranslateGameDto dto){
        return this.translateGameService.create(dto);
    }

    @GetMapping
    public ResponseDto<TranslateGameDto> get(@RequestParam(value = "id") Integer translateId){
        return this.translateGameService.get(translateId);
    }

    @PutMapping
    public ResponseDto<TranslateGameDto> update(@RequestParam(value = "id") Integer translateId, @RequestBody TranslateGameDto dto){
        return this.translateGameService.update(translateId, dto);
    }

    @DeleteMapping
    public ResponseDto<TranslateGameDto> delete(@RequestParam(value = "id") Integer translateId){
        return this.translateGameService.delete(translateId);
    }
}
