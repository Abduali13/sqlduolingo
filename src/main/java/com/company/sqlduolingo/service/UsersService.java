package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    ResponseDto<UsersDto> create(UsersDto dto);

    ResponseDto<UsersDto> get(Integer userId);

    ResponseDto<UsersDto> update(Integer userId, UsersDto dto);

    ResponseDto<UsersDto> delete(Integer userId);

    ResponseDto<List<UsersDto>> listAll();

//    ResponseDto<UsersDto> userRegisterToCourse(UsersDto usersDto, CourseDto courseDto);
//
//    ResponseDto<UsersDto> userCompletesExercies(UsersDto usersDto, ExerciseDto exerciseDto);
//
//    ResponseDto<UsersDto> userHasStatistics(UsersDto usersDto, StatisticsDto statisticsDto);



}
