package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.MatchesGameDto;
import com.company.sqlduolingo.entity.MatchesGame;
import org.springframework.stereotype.Component;

@Component
public class MatchesGameMapper {


    public MatchesGame toEntity(MatchesGameDto dto){
        return MatchesGame.builder()
                .definition(dto.getDefinition())
                .word(dto.getWord())
                .build();
    }

    public MatchesGameDto toDto(MatchesGame matchesGame) {
        return MatchesGameDto.builder()
                .definition(matchesGame.getDefinition())
                .word(matchesGame.getWord())
                .matchId(matchesGame.getMatchId())
                .exerciseId(matchesGame.getExerciseId())
                .createdAt(matchesGame.getCreatedAt())
                .updatedAt(matchesGame.getUpdatedAt())
                .deletedAt(matchesGame.getDeletedAt())
                .build();
    }

    public MatchesGame update(MatchesGame matchesGame, MatchesGameDto dto){
        if (dto.getWord() != null){
            matchesGame.setWord(dto.getWord());
        }
        if (dto.getDefinition() != null){
            matchesGame.setDefinition(dto.getDefinition());
        }
        return matchesGame;
    }
}
