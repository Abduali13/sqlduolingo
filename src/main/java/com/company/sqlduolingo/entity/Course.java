package com.company.sqlduolingo.entity;


import com.company.sqlduolingo.entity.enums.Level;
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
@Table(name = "course")
public class Course extends AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    private String courseName;
    private String description;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(name = "statistics_id")
    private Integer statisticsId;

    @Column(name = "register_id")
    private Integer registerId;

    @OneToMany(mappedBy = "courseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Register> registers;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "statistics_id", insertable = false, updatable = false)
    private Statistics statistics;

    @OneToMany(mappedBy = "courseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Include> includes;

    @OneToMany(mappedBy = "courseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Section> sections;

    @OneToMany(mappedBy = "courseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Keyword> keywords;

    @OneToMany(mappedBy = "courseId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reference> references;



}
