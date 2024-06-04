package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.*;
import com.company.sqlduolingo.entity.Users;
import com.company.sqlduolingo.exception.ResourceNotFoundException;
import com.company.sqlduolingo.repository.UsersRepository;
import com.company.sqlduolingo.service.UsersService;
import com.company.sqlduolingo.service.mapper.UsersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    @Override
    public ResponseDto<UsersDto> create(UsersDto dto) {
        try {
            Users entity = this.usersMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<UsersDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.usersMapper.toDto(
                                    this.usersRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<UsersDto>builder()
                    .code(-2)
                    .message(String.format("User error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<UsersDto> get(Integer userSSN) {
        try {
            Users users = this.usersRepository.findUsersBySSNAndDeletedAtIsNull(userSSN).orElseThrow(() -> new ResourceNotFoundException("Users", "userSSN", userSSN));

            return ResponseDto.<UsersDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.usersMapper.toDto(users)).build();
        }
        catch (Exception e){
            return ResponseDto.<UsersDto>builder()
                    .code(-3)
                    .message(e.getMessage())
                    .build();
        }

    }

    @Override
    public ResponseDto<UsersDto> update(Integer userSSN, UsersDto dto) {
        try {
            Users users = this.usersRepository.findUsersBySSNAndDeletedAtIsNull(userSSN).orElseThrow(() -> new ResourceNotFoundException("Users", "userSSN", userSSN));

            return ResponseDto.<UsersDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.usersMapper.toDto(
                                    this.usersRepository.save(
                                            this.usersMapper.update(
                                                    users, dto
                                            )
                                    )
                            )
                    )
                    .build();
        }
        catch (Exception e){
            return ResponseDto.<UsersDto>builder()
                    .code(-3)
                    .message(e.getMessage())
                    .build();
        }

    }

    @Override
    public ResponseDto<UsersDto> delete(Integer userSSN) {
        try {
            Users users = this.usersRepository.findUsersBySSNAndDeletedAtIsNull(userSSN).orElseThrow(() -> new ResourceNotFoundException("Users", "userSSN", userSSN));

            users.setDeletedAt(LocalDateTime.now());
            return ResponseDto.<UsersDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.usersMapper.toDto(
                                    this.usersRepository.save(users))
                    ).build();
        }
        catch (Exception e){
            return ResponseDto.<UsersDto>builder()
                    .code(-3)
                    .message(e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<List<UsersDto>> listAll() {
        return ResponseDto.<List<UsersDto>>builder()
                .success(true)
                .message("OK")
                .content(
                        this.usersRepository.findAllByDeletedAtIsNull()
                                .stream()
                                .map(this.usersMapper::toDto)
                                .toList())
                .build();
    }


}
