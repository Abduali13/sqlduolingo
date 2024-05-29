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
@Table(name = "matches_game")
public class MatchesGame extends AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchId;

    @Column(name = "exercise_id")
    private Integer exerciseId;

    private String word;
    private String definition;
}
