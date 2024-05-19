package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.MistakeDto;
import com.company.sqlduolingo.entity.Mistake;
import org.springframework.stereotype.Component;

@Component
public class MistakeMapper {

    public Mistake toEntity(MistakeDto dto){
        return Mistake.builder()
                .mistake(dto.getMistake())
                .build();
    }

    public MistakeDto toDto(Mistake mistake){
        return MistakeDto.builder()
                .mistakeId(mistake.getMistakeId())
                .statisticsId(mistake.getStatisticsId())
                .mistake(mistake.getMistake())
                .createdAt(mistake.getCreatedAt())
                .updatedAt(mistake.getUpdatedAt())
                .deletedAt(mistake.getDeletedAt())
                .build();
    }

    public Mistake update(Mistake mistake, MistakeDto dto){
        if (dto.getMistake() != null){
            mistake.setMistake(dto.getMistake());
        }
        return mistake;
    }
}
