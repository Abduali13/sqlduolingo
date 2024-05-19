package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.StatisticsDto;
import org.springframework.stereotype.Service;

@Service
public interface StatisticsService {

    ResponseDto<StatisticsDto> create(StatisticsDto dto);

    ResponseDto<StatisticsDto> get(Integer statisticsId);

    ResponseDto<StatisticsDto> update(Integer statisticsId, StatisticsDto dto);

    ResponseDto<StatisticsDto> delete(Integer statisticsId);

}
