package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.FIGDto;
import com.company.sqlduolingo.entity.FIG;
import org.springframework.stereotype.Component;

@Component
public class FIGMapper {

    public FIG toEntity(FIGDto dto){
        return FIG.builder()
                .sentence(dto.getSentence())
                .build();
    }

    public FIGDto toDto(FIG fig) {
        return FIGDto.builder()
                .figId(fig.getFigId())
                .exerciseId(fig.getExerciseId())
                .sentence(fig.getSentence())
                .createdAt(fig.getCreatedAt())
                .updatedAt(fig.getUpdatedAt())
                .deletedAt(fig.getDeletedAt())
                .build();
    }

    public FIG update(FIG fig, FIGDto dto){
        if (fig.getSentence() != null){
            fig.setSentence(dto.getSentence());
        }
        return fig;
    }
}
