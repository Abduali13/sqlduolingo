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
@Table(name = "translate_game")
public class TranslateGame extends AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer translateId;

    @Column(name = "exercise_id")
    private Integer exerciseId;

    private String query;
    private String sentence;

}
