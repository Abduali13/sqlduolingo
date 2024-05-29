package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.TranslateGameDto;
import com.company.sqlduolingo.entity.TranslateGame;
import com.company.sqlduolingo.repository.TranslateGameRepository;
import com.company.sqlduolingo.service.TranslateGameService;
import com.company.sqlduolingo.service.mapper.TranslateGameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TranslateGameServiceImpl implements TranslateGameService {

    private final TranslateGameRepository translateGameRepository;
    private final TranslateGameMapper translateGameMapper;

    @Override
    public ResponseDto<TranslateGameDto> create(TranslateGameDto dto) {
        try {
            TranslateGame entity = this.translateGameMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<TranslateGameDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.translateGameMapper.toDto(
                                    this.translateGameRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<TranslateGameDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<TranslateGameDto> get(Integer translateId) {
        Optional<TranslateGame> optional = this.translateGameRepository.findTranslateByTranslateIdAndDeletedAtIsNull(translateId);
        if (optional.isEmpty()) {
            return ResponseDto.<TranslateGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", translateId))
                    .build();
        }
        return ResponseDto.<TranslateGameDto>builder()
                .success(true)
                .message("OK")
                .content(this.translateGameMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<TranslateGameDto> update(Integer translateId, TranslateGameDto dto) {
        Optional<TranslateGame> optional = this.translateGameRepository.findTranslateByTranslateIdAndDeletedAtIsNull(translateId);
        if (optional.isEmpty()) {
            return ResponseDto.<TranslateGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", translateId))
                    .build();
        }
        return ResponseDto.<TranslateGameDto>builder()
                .success(true)
                .message("OK")
                .content(this.translateGameMapper.toDto(
                                this.translateGameRepository.save(
                                        this.translateGameMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<TranslateGameDto> delete(Integer translateId) {
        Optional<TranslateGame> optional = this.translateGameRepository.findTranslateByTranslateIdAndDeletedAtIsNull(translateId);
        if (optional.isEmpty()) {
            return ResponseDto.<TranslateGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", translateId))
                    .build();
        }
        TranslateGame translateGame = optional.get();
        translateGame.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<TranslateGameDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.translateGameMapper.toDto(
                                this.translateGameRepository.save(translateGame))
                ).build();
    }
}
