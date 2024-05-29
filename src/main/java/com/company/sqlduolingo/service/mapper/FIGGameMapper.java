package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.FIGGameDto;
import com.company.sqlduolingo.entity.FIGGame;
import org.springframework.stereotype.Component;

@Component
public class FIGGameMapper {

    public FIGGame toEntity(FIGGameDto dto){
        return FIGGame.builder()
                .sentence(dto.getSentence())
                .build();
    }

    public FIGGameDto toDto(FIGGame figGame) {
        return FIGGameDto.builder()
                .figId(figGame.getFigId())
                .exerciseId(figGame.getExerciseId())
                .sentence(figGame.getSentence())
                .createdAt(figGame.getCreatedAt())
                .updatedAt(figGame.getUpdatedAt())
                .deletedAt(figGame.getDeletedAt())
                .build();
    }

    public FIGGame update(FIGGame figGame, FIGGameDto dto){
        if (figGame.getSentence() != null){
            figGame.setSentence(dto.getSentence());
        }
        return figGame;
    }
}
