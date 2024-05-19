package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.TranslateDto;
import com.company.sqlduolingo.entity.Translate;
import com.company.sqlduolingo.repository.TranslateRepository;
import com.company.sqlduolingo.service.TranslateService;
import com.company.sqlduolingo.service.mapper.TranslateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TranslateServiceImpl implements TranslateService {

    private final TranslateRepository translateRepository;
    private final TranslateMapper translateMapper;

    @Override
    public ResponseDto<TranslateDto> create(TranslateDto dto) {
        try {
            Translate entity = this.translateMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<TranslateDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.translateMapper.toDto(
                                    this.translateRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<TranslateDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<TranslateDto> get(Integer translateId) {
        Optional<Translate> optional = this.translateRepository.findTranslateByTranslateIdAndDeletedAtIsNull(translateId);
        if (optional.isEmpty()) {
            return ResponseDto.<TranslateDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", translateId))
                    .build();
        }
        return ResponseDto.<TranslateDto>builder()
                .success(true)
                .message("OK")
                .content(this.translateMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<TranslateDto> update(Integer translateId, TranslateDto dto) {
        Optional<Translate> optional = this.translateRepository.findTranslateByTranslateIdAndDeletedAtIsNull(translateId);
        if (optional.isEmpty()) {
            return ResponseDto.<TranslateDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", translateId))
                    .build();
        }
        return ResponseDto.<TranslateDto>builder()
                .success(true)
                .message("OK")
                .content(this.translateMapper.toDto(
                                this.translateRepository.save(
                                        this.translateMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<TranslateDto> delete(Integer translateId) {
        Optional<Translate> optional = this.translateRepository.findTranslateByTranslateIdAndDeletedAtIsNull(translateId);
        if (optional.isEmpty()) {
            return ResponseDto.<TranslateDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", translateId))
                    .build();
        }
        Translate translate = optional.get();
        translate.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<TranslateDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.translateMapper.toDto(
                                this.translateRepository.save(translate))
                ).build();
    }
}
