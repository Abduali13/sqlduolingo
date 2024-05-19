package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.KeywordDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/keyword")
public class KeywordController {

    private final KeywordService keywordService;

    @PostMapping
    public ResponseDto<KeywordDto> create(@RequestBody KeywordDto dto){
        return this.keywordService.create(dto);
    }

    @GetMapping
    public ResponseDto<KeywordDto> get(@RequestParam(value = "id") Integer keywordId){
        return this.keywordService.get(keywordId);
    }

    @PutMapping
    public ResponseDto<KeywordDto> update(@RequestParam(value = "id") Integer keywordId, @RequestBody KeywordDto dto){
        return this.keywordService.update(keywordId, dto);
    }

    @DeleteMapping
    public ResponseDto<KeywordDto> delete(@RequestParam(value = "id") Integer keywordId){
        return this.keywordService.delete(keywordId);
    }

}
