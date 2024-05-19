package com.company.sqlduolingo.dto;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompleteDto {

    private Integer completeId;

    @Column(name = "ssn")
    private Integer SSN;

    @Column(name = "exercise_id")
    private Integer exerciseId;

    private UsersDto users;

    private ExerciseDto exercise;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


}
