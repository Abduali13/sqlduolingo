package com.company.sqlduolingo.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    private Integer registerId;

    private Integer SSN;

    private Integer courseId;

    private UsersDto users;

    private CourseDto course;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
