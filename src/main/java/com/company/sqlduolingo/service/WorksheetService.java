package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.WorksheetDto;
import org.springframework.stereotype.Service;

@Service
public interface WorksheetService {

    ResponseDto<WorksheetDto> create(WorksheetDto dto);

    ResponseDto<WorksheetDto> get(Integer worksheetId);

    ResponseDto<WorksheetDto> update(Integer worksheetId, WorksheetDto dto);

    ResponseDto<WorksheetDto> delete(Integer worksheetId);

}
