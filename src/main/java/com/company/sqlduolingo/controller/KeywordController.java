package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.KeywordDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/keyword")
public class KeywordController {

    private final KeywordService keywordService;

    @PostMapping
    public ResponseEntity<ResponseDto<KeywordDto>> create(@RequestBody KeywordDto dto){
        return convertStatusCodeByData(this.keywordService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<KeywordDto>> get(@RequestParam(value = "id") Integer keywordId){
        return convertStatusCodeByData(this.keywordService.get(keywordId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<KeywordDto>> update(@RequestParam(value = "id") Integer keywordId, @RequestBody KeywordDto dto){
        return convertStatusCodeByData(this.keywordService.update(keywordId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<KeywordDto>> delete(@RequestParam(value = "id") Integer keywordId){
        return convertStatusCodeByData(this.keywordService.delete(keywordId));
    }

}
