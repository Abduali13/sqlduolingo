package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.UsersDto;
import com.company.sqlduolingo.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<ResponseDto<UsersDto>> create(@RequestBody UsersDto dto){
        return convertStatusCodeByData(this.usersService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<UsersDto>> get(@RequestParam(value = "id") Integer userId){
        return convertStatusCodeByData(this.usersService.get(userId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<UsersDto>> update(@RequestParam(value = "id") Integer userId, @RequestBody UsersDto dto){
        return convertStatusCodeByData(this.usersService.update(userId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<UsersDto>> delete(@RequestParam(value = "id") Integer userId){
        return convertStatusCodeByData(this.usersService.delete(userId));
    }
}
