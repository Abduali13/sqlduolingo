package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.CompleteDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface CompleteService {

    ResponseDto<CompleteDto> create(CompleteDto dto);

    ResponseDto<CompleteDto> get(Integer completeId);

    ResponseDto<CompleteDto> update(Integer completeId);

    ResponseDto<CompleteDto> delete(Integer completeId);

    ResponseDto<CompleteDto> usersCompleteExercise(Integer ssn, Integer exerciseId);

}
