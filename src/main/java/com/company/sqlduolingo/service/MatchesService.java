package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.MatchesDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface MatchesService {

    ResponseDto<MatchesDto> create(MatchesDto dto);

    ResponseDto<MatchesDto> get(Integer matchesId);

    ResponseDto<MatchesDto> update(Integer matchesId, MatchesDto dto);

    ResponseDto<MatchesDto> delete(Integer matchesId);

}
