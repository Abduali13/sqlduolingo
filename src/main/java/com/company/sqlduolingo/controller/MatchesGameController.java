package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.MatchesGameDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.MatchesGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/matches-game")
public class MatchesGameController {

    private final MatchesGameService matchesGameService;

    @PostMapping
    public ResponseDto<MatchesGameDto> create(@RequestBody MatchesGameDto dto){
        return this.matchesGameService.create(dto);
    }

    @GetMapping
    public ResponseDto<MatchesGameDto> get(@RequestParam(value = "id") Integer matchesId){
        return this.matchesGameService.get(matchesId);
    }

    @PutMapping
    public ResponseDto<MatchesGameDto> update(@RequestParam(value = "id") Integer matchesId, @RequestBody MatchesGameDto dto){
        return this.matchesGameService.update(matchesId, dto);
    }

    @DeleteMapping
    public ResponseDto<MatchesGameDto> delete(@RequestParam(value = "id") Integer matchesId){
        return this.matchesGameService.delete(matchesId);
    }




}
