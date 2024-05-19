package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.RegisterDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    ResponseDto<RegisterDto> create(RegisterDto dto);

    ResponseDto<RegisterDto> get(Integer registerId);

    ResponseDto<RegisterDto> update(Integer registerId, RegisterDto dto);

    ResponseDto<RegisterDto> delete(Integer referenceId);

    ResponseDto<RegisterDto> registerUserToCourse(Integer SSN, String courseName);

}
