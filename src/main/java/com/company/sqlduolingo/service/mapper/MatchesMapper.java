package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.MatchesDto;
import com.company.sqlduolingo.entity.Matches;
import org.springframework.stereotype.Component;

@Component
public class MatchesMapper {


    public Matches toEntity(MatchesDto dto){
        return Matches.builder()
                .definition(dto.getDefinition())
                .word(dto.getWord())
                .build();
    }

    public MatchesDto toDto(Matches matches) {
        return MatchesDto.builder()
                .definition(matches.getDefinition())
                .word(matches.getWord())
                .matchId(matches.getMatchId())
                .exerciseId(matches.getExerciseId())
                .createdAt(matches.getCreatedAt())
                .updatedAt(matches.getUpdatedAt())
                .deletedAt(matches.getDeletedAt())
                .build();
    }

    public Matches update(Matches matches, MatchesDto dto){
        if (dto.getWord() != null){
            matches.setWord(dto.getWord());
        }
        if (dto.getDefinition() != null){
            matches.setDefinition(dto.getDefinition());
        }
        return matches;
    }
}
