package com.company.sqlduolingo.service;

import com.company.sqlduolingo.dto.FriendsDto;
import com.company.sqlduolingo.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface FriendsService {

    ResponseDto<FriendsDto> create(FriendsDto dto);

    ResponseDto<FriendsDto> get(Integer friendsId);

    ResponseDto<FriendsDto> update(Integer friendsId, FriendsDto dto);

    ResponseDto<FriendsDto> delete(Integer friendsId);

}
