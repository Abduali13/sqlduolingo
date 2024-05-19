package com.company.sqlduolingo.dto;



import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDto {


    private Integer exampleId;

    private Integer exerciseId;

    private String commands;
    private String definition;


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
