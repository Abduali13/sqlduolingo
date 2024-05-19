package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.KeywordDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Keyword;
import com.company.sqlduolingo.repository.KeywordRepository;
import com.company.sqlduolingo.service.KeywordService;
import com.company.sqlduolingo.service.mapper.KeywordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class KeywordServiceImpl implements KeywordService {

    private final KeywordRepository keywordRepository;
    private final KeywordMapper keywordMapper;

    @Override
    public ResponseDto<KeywordDto> create(KeywordDto dto) {
        try {
            Keyword entity = this.keywordMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<KeywordDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.keywordMapper.toDto(
                                    this.keywordRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<KeywordDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<KeywordDto> get(Integer keywordId) {
        Optional<Keyword> optional = this.keywordRepository.findKeywordsByKeywordIdAndDeletedAtIsNull(keywordId);
        if (optional.isEmpty()) {
            return ResponseDto.<KeywordDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", keywordId))
                    .build();
        }
        return ResponseDto.<KeywordDto>builder()
                .success(true)
                .message("OK")
                .content(this.keywordMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<KeywordDto> update(Integer keywordId, KeywordDto dto) {
        Optional<Keyword> optional = this.keywordRepository.findKeywordsByKeywordIdAndDeletedAtIsNull(keywordId);
        if (optional.isEmpty()) {
            return ResponseDto.<KeywordDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", keywordId))
                    .build();
        }
        return ResponseDto.<KeywordDto>builder()
                .success(true)
                .message("OK")
                .content(this.keywordMapper.toDto(
                                this.keywordRepository.save(
                                        this.keywordMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<KeywordDto> delete(Integer keywordId) {
        Optional<Keyword> optional = this.keywordRepository.findKeywordsByKeywordIdAndDeletedAtIsNull(keywordId);
        if (optional.isEmpty()) {
            return ResponseDto.<KeywordDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", keywordId))
                    .build();
        }
        Keyword keyword = optional.get();
        keyword.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<KeywordDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.keywordMapper.toDto(
                                this.keywordRepository.save(keyword))
                ).build();
    }
}
