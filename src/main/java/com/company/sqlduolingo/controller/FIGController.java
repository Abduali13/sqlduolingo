package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.FIGDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.FIGService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/fig")
public class FIGController {

    private final FIGService figService;

    @PostMapping
    public ResponseDto<FIGDto> create(@RequestBody FIGDto dto){
        return this.figService.create(dto);
    }

    @GetMapping
    public ResponseDto<FIGDto> get(@RequestParam(value = "id") Integer figId){
        return this.figService.get(figId);
    }

    @PutMapping
    public ResponseDto<FIGDto> update(@RequestParam(value = "id") Integer figId, @RequestBody FIGDto dto ){
        return this.figService.update(figId, dto);
    }

    @DeleteMapping
    public ResponseDto<FIGDto> delete(@RequestParam(value = "id") Integer figId){
        return this.figService.delete(figId);
    }



}
