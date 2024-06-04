package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.MistakeDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Mistake;
import com.company.sqlduolingo.repository.MistakeRepository;
import com.company.sqlduolingo.service.MistakeService;
import com.company.sqlduolingo.service.mapper.MistakeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MistakeServiceImpl implements MistakeService {

    private final MistakeRepository mistakeRepository;
    private final MistakeMapper mistakeMapper;

    @Override
    public ResponseDto<MistakeDto> create(MistakeDto dto) {
        try {
            Mistake entity = this.mistakeMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<MistakeDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.mistakeMapper.toDto(
                                    this.mistakeRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<MistakeDto>builder()
                    .code(-2)
                    .message(String.format("Mistake error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<MistakeDto> get(Integer mistakeId) {
        Optional<Mistake> optional = this.mistakeRepository.findMistakeByMistakeIdAndDeletedAtIsNull(mistakeId);
        if (optional.isEmpty()) {
            return ResponseDto.<MistakeDto>builder()
                    .code(-1)
                    .message(String.format("Mistake with %d id is not found", mistakeId))
                    .build();
        }
        return ResponseDto.<MistakeDto>builder()
                .success(true)
                .message("OK")
                .content(this.mistakeMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<MistakeDto> update(Integer mistakeId, MistakeDto dto) {
        Optional<Mistake> optional = this.mistakeRepository.findMistakeByMistakeIdAndDeletedAtIsNull(mistakeId);
        if (optional.isEmpty()) {
            return ResponseDto.<MistakeDto>builder()
                    .code(-1)
                    .message(String.format("Mistake with %d id is not found", mistakeId))
                    .build();
        }
        return ResponseDto.<MistakeDto>builder()
                .success(true)
                .message("OK")
                .content(this.mistakeMapper.toDto(
                                this.mistakeRepository.save(
                                        this.mistakeMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<MistakeDto> delete(Integer mistakeId) {
        Optional<Mistake> optional = this.mistakeRepository.findMistakeByMistakeIdAndDeletedAtIsNull(mistakeId);
        if (optional.isEmpty()) {
            return ResponseDto.<MistakeDto>builder()
                    .code(-1)
                    .message(String.format("Mistake with %d id is not found", mistakeId))
                    .build();
        }
        Mistake mistake = optional.get();
        mistake.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<MistakeDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.mistakeMapper.toDto(
                                this.mistakeRepository.save(mistake))
                ).build();
    }
}
