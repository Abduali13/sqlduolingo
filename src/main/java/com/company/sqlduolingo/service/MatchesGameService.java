package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.MatchesGameDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface MatchesGameService {

    ResponseDto<MatchesGameDto> create(MatchesGameDto dto);

    ResponseDto<MatchesGameDto> get(Integer matchesId);

    ResponseDto<MatchesGameDto> update(Integer matchesId, MatchesGameDto dto);

    ResponseDto<MatchesGameDto> delete(Integer matchesId);

}
