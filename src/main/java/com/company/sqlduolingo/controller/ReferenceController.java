package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ReferenceDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.ReferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/reference")
public class ReferenceController {

    private final ReferenceService referenceService;

    @PostMapping
    public ResponseEntity<ResponseDto<ReferenceDto>> create(@RequestBody ReferenceDto dto){
        return convertStatusCodeByData(this.referenceService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<ReferenceDto>> get(@RequestParam(value = "id") Integer referenceId){
        return convertStatusCodeByData(this.referenceService.get(referenceId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<ReferenceDto>> update(@RequestParam(value = "id") Integer referenceId, @RequestBody ReferenceDto dto){
        return convertStatusCodeByData(this.referenceService.update(referenceId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<ReferenceDto>> delete(@RequestParam(value = "id") Integer referenceId){
        return convertStatusCodeByData(this.referenceService.delete(referenceId));
    }
}
