package com.company.sqlduolingo.service;


import org.springframework.stereotype.Service;

@Service
public interface GameService {

    void playMatchGame(Integer ssn, Integer matchId, String userAnswer);

    void playFIGGame(Integer ssn, Integer figId, String userAnswer);

    void playTranslateGame(Integer ssn, Integer translateId, String userAnswer);

    void playTestGame(Integer ssn, Integer worksheetId, String userAnswer);

    void processGame(Integer ssn, Integer exerciseId, String userAnswer, String correctAnswer);

}
