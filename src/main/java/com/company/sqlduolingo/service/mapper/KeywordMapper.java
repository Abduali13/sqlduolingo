package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.KeywordDto;
import com.company.sqlduolingo.entity.Keyword;
import org.springframework.stereotype.Component;

@Component
public class KeywordMapper {

    public Keyword toEntity(KeywordDto dto){
        return Keyword.builder()
                .keyword(dto.getKeyword())
                .build();
    }

    public KeywordDto toDto(Keyword keyword) {
        return KeywordDto.builder()
                .keywordsId(keyword.getKeywordId())
                .courseId(keyword.getCourseId())
                .keyword(keyword.getKeyword())
                .createdAt(keyword.getCreatedAt())
                .updatedAt(keyword.getUpdatedAt())
                .deletedAt(keyword.getDeletedAt())
                .build();
    }

    public Keyword update(Keyword keyword, KeywordDto dto){
        if (dto.getKeyword() != null){
            keyword.setKeyword(dto.getKeyword());
        }
        return keyword;
    }
}
