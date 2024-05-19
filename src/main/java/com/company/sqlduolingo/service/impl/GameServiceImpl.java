package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.entity.*;
import com.company.sqlduolingo.repository.*;
import com.company.sqlduolingo.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final UsersRepository usersRepository;
    private final MatchesRepository matchesRepository;
    private final FIGRepository figRepository;
    private final TranslateRepository translateRepository;
    private final WorksheetRepository worksheetRepository;
    private final ExerciseRepository exerciseRepository;
    private final StatisticsRepository statisticsRepository;
    private final MistakeRepository mistakeRepository;


    @Override
    public void playMatchGame(Integer ssn, Integer matchId, String userAnswer) {
        Matches matches = this.matchesRepository.findMatchesByMatchIdAndDeletedAtIsNull(matchId).orElseThrow(() -> new RuntimeException("Game can not load"));

        processGame(ssn, matches.getExerciseId(), userAnswer , matches.getDefinition());
    }

    @Override
    public void playFIGGame(Integer ssn, Integer figId, String userAnswer) {
        FIG fig = this.figRepository.findFIGByFigIdAndDeletedAtIsNull(figId).orElseThrow(() -> new RuntimeException("Game can not load"));
        processGame(ssn, fig.getExerciseId(), userAnswer, fig.getSentence());
    }

    @Override
    public void playTranslateGame(Integer ssn, Integer translateId, String userAnswer) {
        Translate translate = this.translateRepository.findTranslateByTranslateIdAndDeletedAtIsNull(translateId).orElseThrow(() -> new RuntimeException("Game can not load"));
        processGame(ssn, translate.getExerciseId(), userAnswer, translate.getSentence());

    }

    @Override
    public void playTestGame(Integer ssn, Integer worksheetId, String userAnswer) {
        Worksheet worksheet = this.worksheetRepository.findWorksheetByWorksheetIdAndDeletedAtIsNull(worksheetId).orElseThrow(() -> new RuntimeException("Game can not load"));
        processGame(ssn, worksheet.getExerciseId(), userAnswer, worksheet.getAnswer());
    }


    @Override
    public void processGame(Integer ssn, Integer exerciseId, String userAnswer, String correctAnswer) {
        Users users = this.usersRepository.findUsersBySSNAndDeletedAtIsNull(ssn).orElseThrow(() -> new RuntimeException("User SSN is not found"));

        Optional<Exercise> optionalExercise = this.exerciseRepository.findExerciseByExerciseIdAndDeletedAtIsNull(exerciseId);

        Statistics stats = new Statistics();
        if (userAnswer.equals(correctAnswer)){
            stats.setScore(stats.getScore() + optionalExercise.get().getScore());
        }
        else {
            Mistake mistake = new Mistake();
            mistake.setMistake(userAnswer + "\nCorrect answer: " + correctAnswer);
            this.mistakeRepository.save(mistake);
            stats.setMistakes(List.of(mistake));
        }
        users.setStatistics(stats);

        this.statisticsRepository.save(stats);
        this.usersRepository.save(users);



    }
}
