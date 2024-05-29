package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.MultipleQuestionGameDto;
import org.springframework.stereotype.Service;

@Service
public interface MultipleQuestionGameService {

    ResponseDto<MultipleQuestionGameDto> create(MultipleQuestionGameDto dto);

    ResponseDto<MultipleQuestionGameDto> get(Integer worksheetId);

    ResponseDto<MultipleQuestionGameDto> update(Integer worksheetId, MultipleQuestionGameDto dto);

    ResponseDto<MultipleQuestionGameDto> delete(Integer worksheetId);

}
