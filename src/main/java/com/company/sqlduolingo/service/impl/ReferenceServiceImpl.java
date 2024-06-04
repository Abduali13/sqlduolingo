package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.ReferenceDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Reference;
import com.company.sqlduolingo.repository.ReferenceRepository;
import com.company.sqlduolingo.service.ReferenceService;
import com.company.sqlduolingo.service.mapper.ReferenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {

    private final ReferenceRepository referenceRepository;
    private final ReferenceMapper referenceMapper;

    @Override
    public ResponseDto<ReferenceDto> create(ReferenceDto dto) {
        try {
            Reference entity = this.referenceMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<ReferenceDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.referenceMapper.toDto(
                                    this.referenceRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<ReferenceDto>builder()
                    .code(-2)
                    .message(String.format("Reference error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<ReferenceDto> get(Integer referenceId) {
        Optional<Reference> optional = this.referenceRepository.findReferenceByReferenceIdAndDeletedAtIsNull(referenceId);
        if (optional.isEmpty()) {
            return ResponseDto.<ReferenceDto>builder()
                    .code(-1)
                    .message(String.format("Reference with %d id is not found", referenceId))
                    .build();
        }
        return ResponseDto.<ReferenceDto>builder()
                .success(true)
                .message("OK")
                .content(this.referenceMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<ReferenceDto> update(Integer referenceId, ReferenceDto dto) {
        Optional<Reference> optional = this.referenceRepository.findReferenceByReferenceIdAndDeletedAtIsNull(referenceId);
        if (optional.isEmpty()) {
            return ResponseDto.<ReferenceDto>builder()
                    .code(-1)
                    .message(String.format("Reference with %d id is not found", referenceId))
                    .build();
        }
        return ResponseDto.<ReferenceDto>builder()
                .success(true)
                .message("OK")
                .content(this.referenceMapper.toDto(
                                this.referenceRepository.save(
                                        this.referenceMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<ReferenceDto> delete(Integer referenceId) {
        Optional<Reference> optional = this.referenceRepository.findReferenceByReferenceIdAndDeletedAtIsNull(referenceId);
        if (optional.isEmpty()) {
            return ResponseDto.<ReferenceDto>builder()
                    .code(-1)
                    .message(String.format("Reference with %d id is not found", referenceId))
                    .build();
        }
        Reference reference = optional.get();
        reference.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<ReferenceDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.referenceMapper.toDto(
                                this.referenceRepository.save(reference))
                ).build();
    }
}
