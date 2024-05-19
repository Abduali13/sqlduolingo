package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.TranslateDto;
import com.company.sqlduolingo.entity.Translate;
import org.springframework.stereotype.Component;

@Component
public class TranslateMapper {

    public Translate toEntity(TranslateDto dto){
        return Translate.builder()
                .query(dto.getQuery())
                .sentence(dto.getSentence())
                .build();
    }

    public TranslateDto toDto(Translate translate){
        return TranslateDto.builder()
                .translateId(translate.getTranslateId())
                .query(translate.getQuery())
                .sentence(translate.getSentence())
                .exerciseId(translate.getExerciseId())
                .createdAt(translate.getCreatedAt())
                .updatedAt(translate.getUpdatedAt())
                .deletedAt(translate.getDeletedAt())
                .build();
    }

    public Translate update(Translate translate, TranslateDto dto){
        if (dto.getQuery() != null) {
            translate.setQuery(dto.getQuery());
        }
        if (dto.getSentence() != null){
            translate.setSentence(dto.getSentence());
        }
        return translate;
    }
}
