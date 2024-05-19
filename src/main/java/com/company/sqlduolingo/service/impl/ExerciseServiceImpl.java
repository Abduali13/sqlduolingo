package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.ExerciseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Exercise;
import com.company.sqlduolingo.repository.ExerciseRepository;
import com.company.sqlduolingo.service.ExerciseService;
import com.company.sqlduolingo.service.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    @Override
    public ResponseDto<ExerciseDto> create(ExerciseDto dto) {
        try {
            Exercise entity = this.exerciseMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<ExerciseDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.exerciseMapper.toDto(
                                    this.exerciseRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<ExerciseDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<ExerciseDto> get(Integer exerciseId) {
        Optional<Exercise> optional = this.exerciseRepository.findExerciseByExerciseIdAndDeletedAtIsNull(exerciseId);
        if (optional.isEmpty()) {
            return ResponseDto.<ExerciseDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", exerciseId))
                    .build();
        }
        return ResponseDto.<ExerciseDto>builder()
                .success(true)
                .message("OK")
                .content(this.exerciseMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<ExerciseDto> update(Integer exerciseId, ExerciseDto dto) {
        Optional<Exercise> optional = this.exerciseRepository.findExerciseByExerciseIdAndDeletedAtIsNull(exerciseId);
        if (optional.isEmpty()) {
            return ResponseDto.<ExerciseDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", exerciseId))
                    .build();
        }
        return ResponseDto.<ExerciseDto>builder()
                .success(true)
                .message("OK")
                .content(this.exerciseMapper.toDto(
                                this.exerciseRepository.save(
                                        this.exerciseMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<ExerciseDto> delete(Integer exerciseId) {
        Optional<Exercise> optional = this.exerciseRepository.findExerciseByExerciseIdAndDeletedAtIsNull(exerciseId);
        if (optional.isEmpty()) {
            return ResponseDto.<ExerciseDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", exerciseId))
                    .build();
        }
        Exercise exercise = optional.get();
        exercise.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<ExerciseDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.exerciseMapper.toDto(
                                this.exerciseRepository.save(exercise))
                ).build();
    }
}
