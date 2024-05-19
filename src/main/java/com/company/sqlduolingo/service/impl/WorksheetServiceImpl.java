package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.AchievementDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.WorksheetDto;
import com.company.sqlduolingo.entity.Achievement;
import com.company.sqlduolingo.entity.Worksheet;
import com.company.sqlduolingo.repository.WorksheetRepository;
import com.company.sqlduolingo.service.WorksheetService;
import com.company.sqlduolingo.service.mapper.WorksheetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class WorksheetServiceImpl implements WorksheetService {

    private final WorksheetRepository worksheetRepository;
    private final WorksheetMapper worksheetMapper;

    @Override
    public ResponseDto<WorksheetDto> create(WorksheetDto dto) {
        try {
            Worksheet entity = this.worksheetMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<WorksheetDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.worksheetMapper.toDto(
                                    this.worksheetRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<WorksheetDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<WorksheetDto> get(Integer worksheetId) {
        Optional<Worksheet> optional = this.worksheetRepository.findWorksheetByWorksheetIdAndDeletedAtIsNull(worksheetId);
        if (optional.isEmpty()) {
            return ResponseDto.<WorksheetDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", worksheetId))
                    .build();
        }
        return ResponseDto.<WorksheetDto>builder()
                .success(true)
                .message("OK")
                .content(this.worksheetMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<WorksheetDto> update(Integer worksheetId, WorksheetDto dto) {
        Optional<Worksheet> optional = this.worksheetRepository.findWorksheetByWorksheetIdAndDeletedAtIsNull(worksheetId);
        if (optional.isEmpty()) {
            return ResponseDto.<WorksheetDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", worksheetId))
                    .build();
        }
        return ResponseDto.<WorksheetDto>builder()
                .success(true)
                .message("OK")
                .content(this.worksheetMapper.toDto(
                                this.worksheetRepository.save(
                                        this.worksheetMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<WorksheetDto> delete(Integer worksheetId) {
        Optional<Worksheet> optional = this.worksheetRepository.findWorksheetByWorksheetIdAndDeletedAtIsNull(worksheetId);
        if (optional.isEmpty()) {
            return ResponseDto.<WorksheetDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", worksheetId))
                    .build();
        }
        Worksheet worksheet = optional.get();
        worksheet.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<WorksheetDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.worksheetMapper.toDto(
                                this.worksheetRepository.save(worksheet))
                ).build();
    }
}
