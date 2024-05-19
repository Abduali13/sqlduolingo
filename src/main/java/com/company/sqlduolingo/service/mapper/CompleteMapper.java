package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.CompleteDto;
import com.company.sqlduolingo.entity.Complete;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CompleteMapper {

    @Lazy
    @Autowired
    private UsersMapper usersMapper;

    @Lazy
    @Autowired
    private ExerciseMapper exerciseMapper;

    public Complete toEntity(CompleteDto dto){
        return Complete.builder().build();
    }

    public CompleteDto toDto(Complete complete){
        return CompleteDto.builder()
                .completeId(complete.getCompleteId())
                .SSN(complete.getSSN())
                .users(usersMapper.toDto(complete.getUsers()))
                .exerciseId(complete.getExerciseId())
                .exercise(exerciseMapper.toDto(complete.getExercise()))
                .createdAt(complete.getCreatedAt())
                .updatedAt(complete.getUpdatedAt())
                .deletedAt(complete.getDeletedAt())
                .build();
    }

    public Complete update(Complete complete, CompleteDto dto){
        return complete;
    }
}
