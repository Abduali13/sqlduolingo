package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/match/{userId}/{matchId}")
    public ResponseDto<Void> playMatchGame(
            @PathVariable Integer userId,
            @PathVariable Integer matchId,
            @RequestBody String userAnswer) {
        gameService.playMatchGame(userId, matchId, userAnswer);
        return ResponseDto.<Void>builder().build();
    }

    @PostMapping("/fig/{userId}/{figId}")
    public ResponseDto<Void> playFIGGame(
            @PathVariable Integer userId,
            @PathVariable Integer figId,
            @RequestBody String userAnswer) {
        gameService.playFIGGame(userId, figId, userAnswer);
        return ResponseDto.<Void>builder().build();
    }

    @PostMapping("/translate/{userId}/{translateId}")
    public ResponseDto<Void> playTranslateGame(
            @PathVariable Integer userId,
            @PathVariable Integer translateId,
            @RequestBody String userAnswer) {
        gameService.playTranslateGame(userId, translateId, userAnswer);
        return ResponseDto.<Void>builder().build();
    }

    @PostMapping("/worksheet/{userId}/{worksheetId}")
    public ResponseDto<Void> playWorksheetGame(
            @PathVariable Integer userId,
            @PathVariable Integer worksheetId,
            @RequestBody String userAnswer) {
        gameService.playTestGame(userId, worksheetId, userAnswer);
        return ResponseDto.<Void>builder().build();
    }

}
