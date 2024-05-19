package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.MatchesDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.MatchesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "matches")
public class MatchesController {

    private final MatchesService matchesService;

    @PostMapping
    public ResponseDto<MatchesDto> create(@RequestBody MatchesDto dto){
        return this.matchesService.create(dto);
    }

    @GetMapping
    public ResponseDto<MatchesDto> get(@RequestParam(value = "id") Integer matchesId){
        return this.matchesService.get(matchesId);
    }

    @PutMapping
    public ResponseDto<MatchesDto> update(@RequestParam(value = "id") Integer matchesId, @RequestBody MatchesDto dto){
        return this.matchesService.update(matchesId, dto);
    }

    @DeleteMapping
    public ResponseDto<MatchesDto> delete(@RequestParam(value = "id") Integer matchesId){
        return this.matchesService.delete(matchesId);
    }




}
