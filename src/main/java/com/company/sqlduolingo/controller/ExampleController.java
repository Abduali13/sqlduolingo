package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ExampleDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "example")
public class ExampleController {

    private final ExampleService exampleService;

    @PostMapping
    public ResponseDto<ExampleDto> create(@RequestBody ExampleDto dto){
        return this.exampleService.create(dto);
    }

    @GetMapping
    public ResponseDto<ExampleDto> get(@RequestParam(value = "id") Integer exampleId){
        return this.exampleService.get(exampleId);
    }

    @PutMapping
    public ResponseDto<ExampleDto> update(@RequestParam(value = "id") Integer exampleId, @RequestBody ExampleDto dto ){
        return this.exampleService.update(exampleId, dto);
    }

    @DeleteMapping
    public ResponseDto<ExampleDto> delete(@RequestParam(value = "id") Integer exampleId){
        return this.exampleService.delete(exampleId);
    }
}
