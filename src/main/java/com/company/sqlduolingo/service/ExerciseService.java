package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.ExerciseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ExerciseService {

    ResponseDto<ExerciseDto> create(ExerciseDto dto);

    ResponseDto<ExerciseDto> get(Integer exerciseId);

    ResponseDto<ExerciseDto> update(Integer exerciseId, ExerciseDto dto);

    ResponseDto<ExerciseDto> delete(Integer exerciseId);

}
