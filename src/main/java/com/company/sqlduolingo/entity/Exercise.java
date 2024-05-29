package com.company.sqlduolingo.entity;

import com.company.sqlduolingo.entity.enums.Level;
import com.company.sqlduolingo.entity.enums.Type;
import com.company.sqlduolingo.entity.template.AbsEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exercise")
public class Exercise extends AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exerciseId;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Level level;

    private Integer score;

    @OneToMany(mappedBy = "exerciseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Include> includes;

    @OneToMany(mappedBy = "exerciseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Complete> completes;

    @OneToMany(mappedBy = "exerciseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Example> examples;

    @OneToMany(mappedBy = "exerciseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MultipleQuestionGame> MultipleQuestionGames;

    @OneToMany(mappedBy = "exerciseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TranslateGame> translateGames;

    @OneToMany(mappedBy = "exerciseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<FIGGame> figGames;

    @OneToMany(mappedBy = "exerciseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MatchesGame> matches;


}
