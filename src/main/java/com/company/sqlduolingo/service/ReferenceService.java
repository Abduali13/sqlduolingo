package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.ReferenceDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ReferenceService {

    ResponseDto<ReferenceDto> create(ReferenceDto dto);

    ResponseDto<ReferenceDto> get(Integer referenceId);

    ResponseDto<ReferenceDto> update(Integer referenceId, ReferenceDto dto);

    ResponseDto<ReferenceDto> delete(Integer referenceId);
}
