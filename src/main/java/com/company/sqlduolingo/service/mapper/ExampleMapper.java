package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.ExampleDto;
import com.company.sqlduolingo.entity.Example;
import org.springframework.stereotype.Component;

@Component
public class ExampleMapper {

    public Example toEntity(ExampleDto dto){
        return Example.builder()
                .commands(dto.getCommands())
                .definition(dto.getDefinition())
                .build();
    }

    public ExampleDto toDto(Example example){
        return ExampleDto.builder()
                .exampleId(example.getExampleId())
                .exerciseId(example.getExerciseId())
                .commands(example.getCommands())
                .definition(example.getDefinition())
                .createdAt(example.getCreatedAt())
                .updatedAt(example.getUpdatedAt())
                .deletedAt(example.getDeletedAt())
                .build();
    }

    public Example update(Example example, ExampleDto dto){
        if (dto.getCommands() != null) {
            example.setCommands(dto.getCommands());
        }
        if (dto.getDefinition() != null){
            example.setDefinition(dto.getDefinition());
        }
        return example;
    }
}
