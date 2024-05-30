package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.TranslateGameDto;
import com.company.sqlduolingo.service.TranslateGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/translate-game")
public class TranslateController {

    private final TranslateGameService translateGameService;

    @PostMapping
    public ResponseEntity<ResponseDto<TranslateGameDto>> create(@RequestBody TranslateGameDto dto){
        return convertStatusCodeByData(this.translateGameService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<TranslateGameDto>> get(@RequestParam(value = "id") Integer translateId){
        return convertStatusCodeByData(this.translateGameService.get(translateId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<TranslateGameDto>> update(@RequestParam(value = "id") Integer translateId, @RequestBody TranslateGameDto dto){
        return convertStatusCodeByData(this.translateGameService.update(translateId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<TranslateGameDto>> delete(@RequestParam(value = "id") Integer translateId){
        return convertStatusCodeByData(this.translateGameService.delete(translateId));
    }
}
