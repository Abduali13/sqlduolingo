package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.UsersDto;
import com.company.sqlduolingo.dto.WorksheetDto;
import com.company.sqlduolingo.service.UsersService;
import com.company.sqlduolingo.service.WorksheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/worksheet")
public class WorksheetController {

    private final WorksheetService worksheetService;

    @PostMapping
    public ResponseDto<WorksheetDto> create(@RequestBody WorksheetDto dto){
        return this.worksheetService.create(dto);
    }

    @GetMapping
    public ResponseDto<WorksheetDto> get(@RequestParam(value = "id") Integer worksheetId){
        return this.worksheetService.get(worksheetId);
    }

    @PutMapping
    public ResponseDto<WorksheetDto> update(@RequestParam(value = "id") Integer worksheetId, @RequestBody WorksheetDto dto){
        return this.worksheetService.update(worksheetId, dto);
    }

    @DeleteMapping
    public ResponseDto<WorksheetDto> delete(@RequestParam(value = "id") Integer worksheetId){
        return this.worksheetService.delete(worksheetId);
    }

}
