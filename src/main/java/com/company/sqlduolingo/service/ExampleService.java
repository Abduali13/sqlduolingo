package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.ExampleDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ExampleService {

    ResponseDto<ExampleDto> create(ExampleDto dto);

    ResponseDto<ExampleDto> get(Integer exampleId);

    ResponseDto<ExampleDto> update(Integer exampleId, ExampleDto dto);

    ResponseDto<ExampleDto> delete(Integer exampleId);
}
