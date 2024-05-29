package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.TranslateGameDto;
import com.company.sqlduolingo.entity.TranslateGame;
import org.springframework.stereotype.Component;

@Component
public class TranslateGameMapper {

    public TranslateGame toEntity(TranslateGameDto dto){
        return TranslateGame.builder()
                .query(dto.getQuery())
                .sentence(dto.getSentence())
                .build();
    }

    public TranslateGameDto toDto(TranslateGame translateGame){
        return TranslateGameDto.builder()
                .translateId(translateGame.getTranslateId())
                .query(translateGame.getQuery())
                .sentence(translateGame.getSentence())
                .exerciseId(translateGame.getExerciseId())
                .createdAt(translateGame.getCreatedAt())
                .updatedAt(translateGame.getUpdatedAt())
                .deletedAt(translateGame.getDeletedAt())
                .build();
    }

    public TranslateGame update(TranslateGame translateGame, TranslateGameDto dto){
        if (dto.getQuery() != null) {
            translateGame.setQuery(dto.getQuery());
        }
        if (dto.getSentence() != null){
            translateGame.setSentence(dto.getSentence());
        }
        return translateGame;
    }
}
