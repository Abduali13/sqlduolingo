package com.company.sqlduolingo.controller;

import com.company.sqlduolingo.dto.FriendsDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.service.FriendsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "friends")
public class FriendsController {

    private final FriendsService friendsService;

    @PostMapping
    public ResponseDto<FriendsDto> create(@RequestBody FriendsDto dto){
        return this.friendsService.create(dto);
    }

    @GetMapping
    public ResponseDto<FriendsDto> get(@RequestParam(value = "id") Integer friendsId){
        return this.friendsService.get(friendsId);
    }

    @PutMapping
    public ResponseDto<FriendsDto> update(@RequestParam(value = "id") Integer friendsId, @RequestBody FriendsDto dto){
        return this.friendsService.update(friendsId, dto);
    }

    @DeleteMapping
    public ResponseDto<FriendsDto> delete(@RequestParam(value = "id") Integer friendsId){
        return this.friendsService.delete(friendsId);
    }

}
