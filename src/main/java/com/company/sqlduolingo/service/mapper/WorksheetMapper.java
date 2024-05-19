package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.WorksheetDto;
import com.company.sqlduolingo.entity.Worksheet;
import org.springframework.stereotype.Component;

@Component
public class WorksheetMapper {

    public Worksheet toEntity(WorksheetDto dto){
        return Worksheet.builder()
                .answer(dto.getAnswer())
                .question(dto.getQuestion())
                .build();
    }

    public WorksheetDto toDto(Worksheet worksheet) {
        return WorksheetDto.builder()
                .worksheetId(worksheet.getWorksheetId())
                .exerciseId(worksheet.getExerciseId())
                .question(worksheet.getQuestion())
                .answer(worksheet.getAnswer())
                .createdAt(worksheet.getCreatedAt())
                .updatedAt(worksheet.getUpdatedAt())
                .deletedAt(worksheet.getDeletedAt())
                .build();
    }

    public Worksheet update(Worksheet worksheet, WorksheetDto dto){
        if (dto.getQuestion() != null){
            worksheet.setQuestion(dto.getAnswer());
        }
        if (dto.getAnswer() != null){
            worksheet.setAnswer(dto.getAnswer());
        }
        return worksheet;
    }
}
