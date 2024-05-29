package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.ExerciseDto;
import com.company.sqlduolingo.entity.Exercise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExerciseMapper {

    private final FIGGameMapper figGameMapper;
    private final IncludeMapper includeMapper;
    private final MatchesGameMapper matchesGameMapper;
    private final CompleteMapper completeMapper;
    private final ExampleMapper exampleMapper;
    private final MultipleQuestionGameMapper multipleQuestionGameMapper;


    public Exercise toEntity(ExerciseDto dto){
        return Exercise.builder()
                .level(dto.getLevel())
                .score(dto.getScore())
                .build();
    }

    public ExerciseDto toDto(Exercise exercise) {
        return ExerciseDto.builder()
                .exerciseId(exercise.getExerciseId())
                .level(exercise.getLevel())
                .score(exercise.getScore())
                .figs(exercise.getFigGames().stream().map(this.figGameMapper::toDto).toList())
                .matches(exercise.getMatches().stream().map(this.matchesGameMapper::toDto).toList())
                .includes(exercise.getIncludes().stream().map(this.includeMapper::toDto).toList())
                .completes(exercise.getCompletes().stream().map(this.completeMapper::toDto).toList())
                .examples(exercise.getExamples().stream().map(this.exampleMapper::toDto).toList())
                .worksheets(exercise.getMultipleQuestionGames().stream().map(this.multipleQuestionGameMapper::toDto).toList())
                .createdAt(exercise.getCreatedAt())
                .updatedAt(exercise.getUpdatedAt())
                .deletedAt(exercise.getDeletedAt())
                .build();
    }

    public Exercise update(Exercise exercise, ExerciseDto dto){
        if (dto.getLevel() != null){
            exercise.setLevel(dto.getLevel());
        }
        if (dto.getScore() != null){
            exercise.setScore(dto.getScore());
        }
        return exercise;
    }
}
