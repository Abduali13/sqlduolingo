package com.company.sqlduolingo.entity;


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
@Table(name = "statistics")
public class Statistics extends AbsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statisticsId;

    private Integer score;

    @Column(name = "course_id")
    private Integer courseId;

    @OneToMany(mappedBy = "statisticsId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses;

    @OneToMany(mappedBy = "statisticsId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Users> users;

    @OneToMany(mappedBy = "statisticsId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Achievement> achievements;

    @OneToMany(mappedBy = "statisticsId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Mistake> mistakes;

}
