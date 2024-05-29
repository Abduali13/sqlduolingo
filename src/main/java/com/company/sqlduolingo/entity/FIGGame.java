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
@Table(name = "fig_game")
public class FIGGame extends AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer figId;

    @Column(name = "exercise_id")
    private Integer exerciseId;

    private String sentence;
}
