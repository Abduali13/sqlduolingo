package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.SectionDto;
import org.springframework.stereotype.Service;

@Service
public interface SectionService {

    ResponseDto<SectionDto> create(SectionDto dto);

    ResponseDto<SectionDto> get(Integer sectionId);

    ResponseDto<SectionDto> update(Integer sectionId, SectionDto dto);

    ResponseDto<SectionDto> delete(Integer sectionId);

}
