package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.TranslateGameDto;
import org.springframework.stereotype.Service;

@Service
public interface TranslateGameService {

    ResponseDto<TranslateGameDto> create(TranslateGameDto dto);

    ResponseDto<TranslateGameDto> get(Integer translateId);

    ResponseDto<TranslateGameDto> update(Integer translateId, TranslateGameDto dto);

    ResponseDto<TranslateGameDto> delete(Integer translateId);

}
