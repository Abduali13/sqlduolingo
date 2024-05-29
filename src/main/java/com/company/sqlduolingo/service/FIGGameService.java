package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.FIGGameDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface FIGGameService {

    ResponseDto<FIGGameDto> create(FIGGameDto dto);

    ResponseDto<FIGGameDto> get(Integer figId);

    ResponseDto<FIGGameDto> update(Integer figId, FIGGameDto dto);

    ResponseDto<FIGGameDto> delete(Integer figId);

}
