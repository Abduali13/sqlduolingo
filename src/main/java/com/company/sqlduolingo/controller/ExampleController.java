package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ExampleDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/example")
public class ExampleController {

    private final ExampleService exampleService;

    @PostMapping
    public ResponseEntity<ResponseDto<ExampleDto>> create(@RequestBody ExampleDto dto){
        return convertStatusCodeByData(this.exampleService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<ExampleDto>> get(@RequestParam(value = "id") Integer exampleId){
        return convertStatusCodeByData(this.exampleService.get(exampleId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<ExampleDto>> update(@RequestParam(value = "id") Integer exampleId, @RequestBody ExampleDto dto ){
        return convertStatusCodeByData(this.exampleService.update(exampleId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<ExampleDto>> delete(@RequestParam(value = "id") Integer exampleId){
        return convertStatusCodeByData(this.exampleService.delete(exampleId));
    }
}
