package com.company.sqlduolingo.dto;

import com.company.sqlduolingo.entity.MultipleQuestionGame;
import com.company.sqlduolingo.entity.enums.Level;
import com.company.sqlduolingo.entity.enums.Type;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDto {

    private Integer exerciseId;

    private Type type;

    private Level level;

    private Integer score;

    private List<IncludeDto> includes;

    private List<CompleteDto> completes;

    private List<ExampleDto> examples;

    private List<MultipleQuestionGameDto> worksheets;

    private List<TranslateGameDto> translates;

    private List<FIGGameDto> figs;

    private List<MatchesGameDto> matches;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
