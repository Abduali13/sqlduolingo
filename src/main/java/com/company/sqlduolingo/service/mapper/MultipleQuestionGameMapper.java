package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.MultipleQuestionGameDto;
import com.company.sqlduolingo.entity.MultipleQuestionGame;
import org.springframework.stereotype.Component;

@Component
public class MultipleQuestionGameMapper {

    public MultipleQuestionGame toEntity(MultipleQuestionGameDto dto){
        return MultipleQuestionGame.builder()
                .answer(dto.getAnswer())
                .question(dto.getQuestion())
                .build();
    }

    public MultipleQuestionGameDto toDto(MultipleQuestionGame MultipleQuestionGame) {
        return MultipleQuestionGameDto.builder()
                .worksheetId(MultipleQuestionGame.getWorksheetId())
                .exerciseId(MultipleQuestionGame.getExerciseId())
                .question(MultipleQuestionGame.getQuestion())
                .answer(MultipleQuestionGame.getAnswer())
                .createdAt(MultipleQuestionGame.getCreatedAt())
                .updatedAt(MultipleQuestionGame.getUpdatedAt())
                .deletedAt(MultipleQuestionGame.getDeletedAt())
                .build();
    }

    public MultipleQuestionGame update(MultipleQuestionGame MultipleQuestionGame, MultipleQuestionGameDto dto){
        if (dto.getQuestion() != null){
            MultipleQuestionGame.setQuestion(dto.getAnswer());
        }
        if (dto.getAnswer() != null){
            MultipleQuestionGame.setAnswer(dto.getAnswer());
        }
        return MultipleQuestionGame;
    }
}
