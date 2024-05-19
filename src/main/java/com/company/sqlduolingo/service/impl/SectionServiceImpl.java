package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.SectionDto;
import com.company.sqlduolingo.entity.Section;
import com.company.sqlduolingo.repository.SectionRepository;
import com.company.sqlduolingo.service.SectionService;
import com.company.sqlduolingo.service.mapper.SectionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;
    private final SectionMapper sectionMapper;

    @Override
    public ResponseDto<SectionDto> create(SectionDto dto) {
        try {
            Section entity = this.sectionMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<SectionDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.sectionMapper.toDto(
                                    this.sectionRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<SectionDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<SectionDto> get(Integer sectionId) {
        Optional<Section> optional = this.sectionRepository.findSectionBySectionIdAndDeletedAtIsNull(sectionId);
        if (optional.isEmpty()) {
            return ResponseDto.<SectionDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", sectionId))
                    .build();
        }
        return ResponseDto.<SectionDto>builder()
                .success(true)
                .message("OK")
                .content(this.sectionMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<SectionDto> update(Integer sectionId, SectionDto dto) {
        Optional<Section> optional = this.sectionRepository.findSectionBySectionIdAndDeletedAtIsNull(sectionId);
        if (optional.isEmpty()) {
            return ResponseDto.<SectionDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", sectionId))
                    .build();
        }
        return ResponseDto.<SectionDto>builder()
                .success(true)
                .message("OK")
                .content(this.sectionMapper.toDto(
                                this.sectionRepository.save(
                                        this.sectionMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<SectionDto> delete(Integer sectionId) {
        Optional<Section> optional = this.sectionRepository.findSectionBySectionIdAndDeletedAtIsNull(sectionId);
        if (optional.isEmpty()) {
            return ResponseDto.<SectionDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", sectionId))
                    .build();
        }
        Section section = optional.get();
        section.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<SectionDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.sectionMapper.toDto(
                                this.sectionRepository.save(section))
                ).build();
    }
}
