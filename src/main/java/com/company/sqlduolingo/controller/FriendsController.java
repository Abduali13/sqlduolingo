package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.FriendsDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.FriendsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.sqlduolingo.dto.SimpleResponseDto.convertStatusCodeByData;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/friends")
public class FriendsController {

    private final FriendsService friendsService;

    @PostMapping
    public ResponseEntity<ResponseDto<FriendsDto>> create(@RequestBody FriendsDto dto){
        return convertStatusCodeByData(this.friendsService.create(dto));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<FriendsDto>> get(@RequestParam(value = "id") Integer friendsId){
        return convertStatusCodeByData(this.friendsService.get(friendsId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto<FriendsDto>> update(@RequestParam(value = "id") Integer friendsId, @RequestBody FriendsDto dto){
        return convertStatusCodeByData(this.friendsService.update(friendsId, dto));
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto<FriendsDto>> delete(@RequestParam(value = "id") Integer friendsId){
        return convertStatusCodeByData(this.friendsService.delete(friendsId));
    }

}
