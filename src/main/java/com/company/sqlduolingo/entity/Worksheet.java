package com.company.sqlduolingo.entity;

import com.company.sqlduolingo.entity.template.AbsEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "worksheet")
public class Worksheet extends AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer worksheetId;

    @Column(name = "exercise_id")
    private Integer exerciseId;

    private String question;
    private String answer;
}
