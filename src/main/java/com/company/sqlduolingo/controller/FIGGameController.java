package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.FIGGameDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.FIGGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/fig-game")
public class FIGGameController {

    private final FIGGameService figGameService;

    @PostMapping
    public ResponseDto<FIGGameDto> create(@RequestBody FIGGameDto dto){
        return this.figGameService.create(dto);
    }

    @GetMapping
    public ResponseDto<FIGGameDto> get(@RequestParam(value = "id") Integer figId){
        return this.figGameService.get(figId);
    }

    @PutMapping
    public ResponseDto<FIGGameDto> update(@RequestParam(value = "id") Integer figId, @RequestBody FIGGameDto dto ){
        return this.figGameService.update(figId, dto);
    }

    @DeleteMapping
    public ResponseDto<FIGGameDto> delete(@RequestParam(value = "id") Integer figId){
        return this.figGameService.delete(figId);
    }



}
