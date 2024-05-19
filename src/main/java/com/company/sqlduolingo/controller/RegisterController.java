package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.RegisterDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/register")
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("/registerToCourse/{ssn}/{courseName}")
    public ResponseDto<RegisterDto> registerToCourse(@PathVariable Integer ssn, @PathVariable String courseName){
        return this.registerService.registerUserToCourse(ssn, courseName);
    }

    @PostMapping
    public ResponseDto<RegisterDto> create(@RequestBody RegisterDto dto){
        return this.registerService.create(dto);
    }

    @GetMapping
    public ResponseDto<RegisterDto> get(@RequestParam(value = "id") Integer registerId){
        return this.registerService.get(registerId);
    }

    @PutMapping
    public ResponseDto<RegisterDto> update(@RequestParam(value = "id") Integer registerId, @RequestBody RegisterDto dto){
        return this.registerService.update(registerId, dto);
    }

    @DeleteMapping
    public ResponseDto<RegisterDto> delete(@RequestParam(value = "id") Integer referenceId){
        return this.registerService.delete(referenceId);
    }


}
