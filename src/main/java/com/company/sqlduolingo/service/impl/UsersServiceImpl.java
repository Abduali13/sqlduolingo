package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.*;
import com.company.sqlduolingo.entity.Users;
import com.company.sqlduolingo.repository.UsersRepository;
import com.company.sqlduolingo.service.UsersService;
import com.company.sqlduolingo.service.mapper.UsersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
            Optional<Users> optional = this.usersRepository.findUsersBySSNAndDeletedAtIsNull(userSSN);
            if (optional.isEmpty()) {
                return ResponseDto.<UsersDto>builder()
                        .code(-1)
                        .message(String.format("User with %d id is not found", userSSN))
                        .build();
            }
            return ResponseDto.<UsersDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.usersMapper.toDto(optional.get())).build();
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
        Optional<Users> optional = this.usersRepository.findUsersBySSNAndDeletedAtIsNull(userSSN);
        if (optional.isEmpty()) {
            return ResponseDto.<UsersDto>builder()
                    .code(-1)
                    .message(String.format("User with %d id is not found", userSSN))
                    .build();
        }
        return ResponseDto.<UsersDto>builder()
                .success(true)
                .message("OK")
                .content(this.usersMapper.toDto(
                                this.usersRepository.save(
                                        this.usersMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<UsersDto> delete(Integer userSSN) {
        Optional<Users> optional = this.usersRepository.findUsersBySSNAndDeletedAtIsNull(userSSN);
        if (optional.isEmpty()) {
            return ResponseDto.<UsersDto>builder()
                    .code(-1)
                    .message(String.format("User with %d id is not found", userSSN))
                    .build();
        }
        Users users = optional.get();
        users.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<UsersDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.usersMapper.toDto(
                                this.usersRepository.save(users))
                ).build();
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
