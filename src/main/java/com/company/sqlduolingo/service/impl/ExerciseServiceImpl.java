package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.ExerciseDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Exercise;
import com.company.sqlduolingo.exception.ResourceNotFoundException;
import com.company.sqlduolingo.repository.ExerciseRepository;
import com.company.sqlduolingo.service.ExerciseService;
import com.company.sqlduolingo.service.mapper.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
                    .message(String.format("Exercise error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<ExerciseDto> get(Integer exerciseId) {
        try {


            Exercise exercise = this.exerciseRepository.findExerciseByExerciseIdAndDeletedAtIsNull(exerciseId).orElseThrow(() -> new ResourceNotFoundException("Exercise", "exerciseId", exerciseId));

            return ResponseDto.<ExerciseDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.exerciseMapper.toDto(exercise)).build();
        }

        catch (Exception e) {
            return ResponseDto.<ExerciseDto>builder()
                    .code(-3)
                    .message(e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<ExerciseDto> update(Integer exerciseId, ExerciseDto dto) {
        try {
            Exercise exercise = this.exerciseRepository.findExerciseByExerciseIdAndDeletedAtIsNull(exerciseId).orElseThrow(() -> new ResourceNotFoundException("Exercise", "exerciseId", exerciseId));
            return ResponseDto.<ExerciseDto>builder()
                    .success(true)
                    .message("OK")
                    .content(this.exerciseMapper.toDto(
                                    this.exerciseRepository.save(
                                            this.exerciseMapper.update(
                                                    exercise, dto
                                            )
                                    )
                            )
                    )
                    .build();
        }

        catch (Exception e) {
            return ResponseDto.<ExerciseDto>builder()
                    .code(-3)
                    .message(e.getMessage())
                    .build();
        }
    }

    @Override
    public ResponseDto<ExerciseDto> delete(Integer exerciseId) {
        try {
            Exercise exercise = this.exerciseRepository.findExerciseByExerciseIdAndDeletedAtIsNull(exerciseId).orElseThrow(() -> new ResourceNotFoundException("Exercise", "exerciseId", exerciseId));

            exercise.setDeletedAt(LocalDateTime.now());
            return ResponseDto.<ExerciseDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.exerciseMapper.toDto(
                                    this.exerciseRepository.save(exercise))
                    ).build();
        }

        catch (Exception e) {
            return ResponseDto.<ExerciseDto>builder()
                    .code(-3)
                    .message(e.getMessage())
                    .build();
        }
    }
}
