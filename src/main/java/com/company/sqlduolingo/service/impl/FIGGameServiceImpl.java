package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.FIGGameDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.FIGGame;
import com.company.sqlduolingo.repository.FIGGameRepository;
import com.company.sqlduolingo.service.FIGGameService;
import com.company.sqlduolingo.service.mapper.FIGGameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FIGGameServiceImpl implements FIGGameService {

    private final FIGGameRepository figGameRepository;
    private final FIGGameMapper figGameMapper;

    @Override
    public ResponseDto<FIGGameDto> create(FIGGameDto dto) {
        try {
            FIGGame entity = this.figGameMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<FIGGameDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.figGameMapper.toDto(
                                    this.figGameRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<FIGGameDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }
    @Override
    public ResponseDto<FIGGameDto> get(Integer figId) {
        Optional<FIGGame> optional = this.figGameRepository.findFIGByFigIdAndDeletedAtIsNull(figId);
        if (optional.isEmpty()) {
            return ResponseDto.<FIGGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", figId))
                    .build();
        }
        return ResponseDto.<FIGGameDto>builder()
                .success(true)
                .message("OK")
                .content(this.figGameMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<FIGGameDto> update(Integer figId, FIGGameDto dto) {
        Optional<FIGGame> optional = this.figGameRepository.findFIGByFigIdAndDeletedAtIsNull(figId);
        if (optional.isEmpty()) {
            return ResponseDto.<FIGGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", figId))
                    .build();
        }
        return ResponseDto.<FIGGameDto>builder()
                .success(true)
                .message("OK")
                .content(this.figGameMapper.toDto(
                                this.figGameRepository.save(
                                        this.figGameMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<FIGGameDto> delete(Integer figId) {
        Optional<FIGGame> optional = this.figGameRepository.findFIGByFigIdAndDeletedAtIsNull(figId);
        if (optional.isEmpty()) {
            return ResponseDto.<FIGGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", figId))
                    .build();
        }
        FIGGame figGame = optional.get();
        figGame.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<FIGGameDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.figGameMapper.toDto(
                                this.figGameRepository.save(figGame))
                ).build();
    }
}
