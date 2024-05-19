package com.company.sqlduolingo.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {


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

    private Integer statisticsId;

    private Integer registerId;

    private List<RegisterDto> registers;

    private List<FriendsDto> friends;

    private List<CompleteDto> completes;

    private StatisticsDto statistics;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
