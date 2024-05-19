package com.company.sqlduolingo.service.impl;


import com.company.sqlduolingo.dto.ExampleDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Example;
import com.company.sqlduolingo.repository.ExampleRepository;
import com.company.sqlduolingo.service.ExampleService;
import com.company.sqlduolingo.service.mapper.ExampleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService {


    private final ExampleRepository exampleRepository;
    private final ExampleMapper exampleMapper;

    @Override
    public ResponseDto<ExampleDto> create(ExampleDto dto) {
        try {
            Example entity = this.exampleMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<ExampleDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.exampleMapper.toDto(
                                    this.exampleRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<ExampleDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<ExampleDto> get(Integer exampleId) {
        Optional<Example> optional = this.exampleRepository.findExampleByExampleIdAndDeletedAtIsNull(exampleId);
        if (optional.isEmpty()) {
            return ResponseDto.<ExampleDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", exampleId))
                    .build();
        }
        return ResponseDto.<ExampleDto>builder()
                .success(true)
                .message("OK")
                .content(this.exampleMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<ExampleDto> update(Integer exampleId, ExampleDto dto) {
        Optional<Example> optional = this.exampleRepository.findExampleByExampleIdAndDeletedAtIsNull(exampleId);
        if (optional.isEmpty()) {
            return ResponseDto.<ExampleDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", exampleId))
                    .build();
        }
        return ResponseDto.<ExampleDto>builder()
                .success(true)
                .message("OK")
                .content(this.exampleMapper.toDto(
                                this.exampleRepository.save(
                                        this.exampleMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<ExampleDto> delete(Integer exampleId) {
        Optional<Example> optional = this.exampleRepository.findExampleByExampleIdAndDeletedAtIsNull(exampleId);
        if (optional.isEmpty()) {
            return ResponseDto.<ExampleDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", exampleId))
                    .build();
        }
        Example example = optional.get();
        example.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<ExampleDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.exampleMapper.toDto(
                                this.exampleRepository.save(example))
                ).build();
    }
}
