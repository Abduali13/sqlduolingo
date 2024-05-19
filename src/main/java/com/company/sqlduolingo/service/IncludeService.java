package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.IncludeDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface IncludeService {


    ResponseDto<IncludeDto> create(IncludeDto dto);

    ResponseDto<IncludeDto> get(Integer includeId);

    ResponseDto<IncludeDto> update(Integer includeId, IncludeDto dto);

    ResponseDto<IncludeDto> delete(Integer includeId);

    ResponseDto<IncludeDto> courseIncludesExercise(Integer courseId, Integer exerciseId);
}
