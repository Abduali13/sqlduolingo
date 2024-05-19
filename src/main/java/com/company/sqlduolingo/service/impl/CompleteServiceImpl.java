package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.CompleteDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Complete;
import com.company.sqlduolingo.entity.Exercise;
import com.company.sqlduolingo.entity.Users;
import com.company.sqlduolingo.repository.CompleteRepository;
import com.company.sqlduolingo.repository.ExerciseRepository;
import com.company.sqlduolingo.repository.RegisterRepository;
import com.company.sqlduolingo.repository.UsersRepository;
import com.company.sqlduolingo.service.CompleteService;
import com.company.sqlduolingo.service.mapper.CompleteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CompleteServiceImpl implements CompleteService {

    private final RegisterRepository registerRepository;
    private final UsersRepository usersRepository;
    private final ExerciseRepository exerciseRepository;
    private final CompleteRepository completeRepository;
    private final CompleteMapper completeMapper;

    @Override
    public ResponseDto<CompleteDto> usersCompleteExercise(Integer ssn, Integer exerciseId) {
        Optional<Users> optionalUsers = this.usersRepository.findUsersBySSNAndDeletedAtIsNull(ssn);
        if (optionalUsers.isEmpty()) {
            return ResponseDto.<CompleteDto>builder()
                    .code(-1)
                    .message("User is not found")
                    .build();
        }
        Optional<Exercise> optionalExercise = this.exerciseRepository.findExerciseByExerciseIdAndDeletedAtIsNull(exerciseId);
        if (optionalExercise.isEmpty()) {
            return ResponseDto.<CompleteDto>builder()
                    .code(-1)
                    .message("Exercise is not found")
                    .build();
        }

        if (!this.registerRepository.existsByUserIdAndExerciseId(ssn, exerciseId)) {
            throw new RuntimeException("User is not registered for the course containing this exercise");
        }

        Complete complete = new Complete();
        complete.setExerciseId(exerciseId);
        complete.setExercise(optionalExercise.get());
        complete.setSSN(ssn);
        complete.setUsers(optionalUsers.get());
        return ResponseDto.<CompleteDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.completeMapper.toDto(
                                this.completeRepository.save(complete)
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<CompleteDto> create(CompleteDto dto) {
        return null;
    }

    @Override
    public ResponseDto<CompleteDto> get(Integer completeId) {
        return null;
    }

    @Override
    public ResponseDto<CompleteDto> update(Integer completeId) {
        return null;
    }

    @Override
    public ResponseDto<CompleteDto> delete(Integer completeId) {
        return null;
    }


}
