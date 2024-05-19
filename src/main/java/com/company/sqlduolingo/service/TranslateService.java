package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.TranslateDto;
import org.springframework.stereotype.Service;

@Service
public interface TranslateService {

    ResponseDto<TranslateDto> create(TranslateDto dto);

    ResponseDto<TranslateDto> get(Integer translateId);

    ResponseDto<TranslateDto> update(Integer translateId, TranslateDto dto);

    ResponseDto<TranslateDto> delete(Integer translateId);

}
