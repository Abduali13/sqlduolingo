package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.MistakeDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface MistakeService {

    ResponseDto<MistakeDto> create(MistakeDto dto);

    ResponseDto<MistakeDto> get(Integer mistakeId);

    ResponseDto<MistakeDto> update(Integer mistakeId, MistakeDto dto);

    ResponseDto<MistakeDto> delete(Integer mistakeId);

}
