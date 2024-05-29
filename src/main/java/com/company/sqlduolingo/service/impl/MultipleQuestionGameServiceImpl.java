package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.MultipleQuestionGameDto;
import com.company.sqlduolingo.entity.MultipleQuestionGame;
import com.company.sqlduolingo.repository.MultipleQuestionGameRepository;
import com.company.sqlduolingo.service.MultipleQuestionGameService;
import com.company.sqlduolingo.service.mapper.MultipleQuestionGameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MultipleQuestionGameServiceImpl implements MultipleQuestionGameService {

    private final MultipleQuestionGameRepository multipleQuestionGameRepository;
    private final MultipleQuestionGameMapper multipleQuestionGameMapper;

    @Override
    public ResponseDto<MultipleQuestionGameDto> create(MultipleQuestionGameDto dto) {
        try {
            MultipleQuestionGame entity = this.multipleQuestionGameMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<MultipleQuestionGameDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.multipleQuestionGameMapper.toDto(
                                    this.multipleQuestionGameRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<MultipleQuestionGameDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<MultipleQuestionGameDto> get(Integer worksheetId) {
        Optional<MultipleQuestionGame> optional = this.multipleQuestionGameRepository.findWorksheetByWorksheetIdAndDeletedAtIsNull(worksheetId);
        if (optional.isEmpty()) {
            return ResponseDto.<MultipleQuestionGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", worksheetId))
                    .build();
        }
        return ResponseDto.<MultipleQuestionGameDto>builder()
                .success(true)
                .message("OK")
                .content(this.multipleQuestionGameMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<MultipleQuestionGameDto> update(Integer worksheetId, MultipleQuestionGameDto dto) {
        Optional<MultipleQuestionGame> optional = this.multipleQuestionGameRepository.findWorksheetByWorksheetIdAndDeletedAtIsNull(worksheetId);
        if (optional.isEmpty()) {
            return ResponseDto.<MultipleQuestionGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", worksheetId))
                    .build();
        }
        return ResponseDto.<MultipleQuestionGameDto>builder()
                .success(true)
                .message("OK")
                .content(this.multipleQuestionGameMapper.toDto(
                                this.multipleQuestionGameRepository.save(
                                        this.multipleQuestionGameMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<MultipleQuestionGameDto> delete(Integer worksheetId) {
        Optional<MultipleQuestionGame> optional = this.multipleQuestionGameRepository.findWorksheetByWorksheetIdAndDeletedAtIsNull(worksheetId);
        if (optional.isEmpty()) {
            return ResponseDto.<MultipleQuestionGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", worksheetId))
                    .build();
        }
        MultipleQuestionGame MultipleQuestionGame = optional.get();
        MultipleQuestionGame.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<MultipleQuestionGameDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.multipleQuestionGameMapper.toDto(
                                this.multipleQuestionGameRepository.save(MultipleQuestionGame))
                ).build();
    }
}
