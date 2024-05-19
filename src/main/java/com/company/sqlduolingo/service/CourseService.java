package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.CourseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {

    ResponseDto<CourseDto> create(CourseDto dto);

    ResponseDto<CourseDto> get(Integer courseId);

    ResponseDto<CourseDto> update(Integer courseId, CourseDto dto);

    ResponseDto<CourseDto> delete(Integer courseId);

}
