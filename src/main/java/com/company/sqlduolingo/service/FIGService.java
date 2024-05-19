package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.FIGDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface FIGService {

    ResponseDto<FIGDto> create(FIGDto dto);

    ResponseDto<FIGDto> get(Integer figId);

    ResponseDto<FIGDto> update(Integer figId, FIGDto dto);

    ResponseDto<FIGDto> delete(Integer figId);

}
