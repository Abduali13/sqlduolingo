package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.KeywordDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface KeywordService {

    ResponseDto<KeywordDto> create(KeywordDto dto);

    ResponseDto<KeywordDto> get(Integer keywordId);

    ResponseDto<KeywordDto> update(Integer keywordId, KeywordDto dto);

    ResponseDto<KeywordDto> delete(Integer keywordId);

}
