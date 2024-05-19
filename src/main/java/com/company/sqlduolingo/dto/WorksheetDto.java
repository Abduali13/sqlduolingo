package com.company.sqlduolingo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorksheetDto {

    private Integer worksheetId;

    private Integer exerciseId;

    private String question;
    private String answer;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
