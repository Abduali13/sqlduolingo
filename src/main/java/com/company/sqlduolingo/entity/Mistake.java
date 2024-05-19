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
@Table(name = "mistake")
public class Mistake extends AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mistakeId;

    @Column(name = "statistics_id")
    private Integer statisticsId;

    private String mistake;
}
