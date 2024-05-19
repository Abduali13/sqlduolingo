package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.FIGDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.FIG;
import com.company.sqlduolingo.repository.FIGRepository;
import com.company.sqlduolingo.service.FIGService;
import com.company.sqlduolingo.service.mapper.FIGMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FIGServiceImpl implements FIGService {

    private final FIGRepository figRepository;
    private final FIGMapper figMapper;

    @Override
    public ResponseDto<FIGDto> create(FIGDto dto) {
        try {
            FIG entity = this.figMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<FIGDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.figMapper.toDto(
                                    this.figRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<FIGDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }
    @Override
    public ResponseDto<FIGDto> get(Integer figId) {
        Optional<FIG> optional = this.figRepository.findFIGByFigIdAndDeletedAtIsNull(figId);
        if (optional.isEmpty()) {
            return ResponseDto.<FIGDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", figId))
                    .build();
        }
        return ResponseDto.<FIGDto>builder()
                .success(true)
                .message("OK")
                .content(this.figMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<FIGDto> update(Integer figId, FIGDto dto) {
        Optional<FIG> optional = this.figRepository.findFIGByFigIdAndDeletedAtIsNull(figId);
        if (optional.isEmpty()) {
            return ResponseDto.<FIGDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", figId))
                    .build();
        }
        return ResponseDto.<FIGDto>builder()
                .success(true)
                .message("OK")
                .content(this.figMapper.toDto(
                                this.figRepository.save(
                                        this.figMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<FIGDto> delete(Integer figId) {
        Optional<FIG> optional = this.figRepository.findFIGByFigIdAndDeletedAtIsNull(figId);
        if (optional.isEmpty()) {
            return ResponseDto.<FIGDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", figId))
                    .build();
        }
        FIG fig = optional.get();
        fig.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<FIGDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.figMapper.toDto(
                                this.figRepository.save(fig))
                ).build();
    }
}
