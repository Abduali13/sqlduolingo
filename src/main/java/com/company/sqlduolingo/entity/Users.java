package com.company.sqlduolingo.entity;


import com.company.sqlduolingo.entity.template.AbsEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class Users extends AbsEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer SSN;

    private String name;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Date birthDate;
    private Date joinedDate;
    private String courseTaken;
    private Integer friendsFollowing;
    private Integer friendsFollowers;

    @Column(name = "statistics_id")
    private Integer statisticsId;

    @Column(name = "register_id")
    private Integer registerId;

    @OneToMany(mappedBy = "SSN", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Register> registers;

    @OneToMany(mappedBy = "SSN", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Friends> friends;

    @OneToMany(mappedBy = "SSN", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Complete> completes;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "statistics_id", insertable = false, updatable = false)
    private Statistics statistics;


}
