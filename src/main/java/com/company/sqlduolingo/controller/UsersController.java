package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.UsersDto;
import com.company.sqlduolingo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseDto<UsersDto> create(@RequestBody UsersDto dto){
        return this.usersService.create(dto);
    }

    @GetMapping
    public ResponseDto<UsersDto> get(@RequestParam(value = "id") Integer userId){
        return this.usersService.get(userId);
    }

    @PutMapping
    public ResponseDto<UsersDto> update(@RequestParam(value = "id") Integer userId, @RequestBody UsersDto dto){
        return this.usersService.update(userId, dto);
    }

    @DeleteMapping
    public ResponseDto<UsersDto> delete(@RequestParam(value = "id") Integer userId){
        return this.usersService.delete(userId);
    }
}
