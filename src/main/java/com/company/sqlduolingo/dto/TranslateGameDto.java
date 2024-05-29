package com.company.sqlduolingo.dto;



import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TranslateGameDto {

    private Integer translateId;

    private Integer exerciseId;

    private String query;
    private String sentence;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
