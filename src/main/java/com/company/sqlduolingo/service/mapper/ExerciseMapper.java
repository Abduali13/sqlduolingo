package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.ExerciseDto;
import com.company.sqlduolingo.entity.Exercise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExerciseMapper {

    private final FIGMapper figMapper;
    private final IncludeMapper includeMapper;
    private final MatchesMapper matchesMapper;
    private final CompleteMapper completeMapper;
    private final ExampleMapper exampleMapper;
    private final WorksheetMapper worksheetMapper;


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
                .figs(exercise.getFigs().stream().map(this.figMapper::toDto).toList())
                .matches(exercise.getMatches().stream().map(this.matchesMapper::toDto).toList())
                .includes(exercise.getIncludes().stream().map(this.includeMapper::toDto).toList())
                .completes(exercise.getCompletes().stream().map(this.completeMapper::toDto).toList())
                .examples(exercise.getExamples().stream().map(this.exampleMapper::toDto).toList())
                .worksheets(exercise.getWorksheets().stream().map(this.worksheetMapper::toDto).toList())
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
