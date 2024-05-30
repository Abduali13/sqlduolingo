package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.UsersDto;
import com.company.sqlduolingo.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    @Lazy
    @Autowired
    private RegisterMapper registerMapper;

    @Lazy
    @Autowired
    private StatisticsMapper statisticsMapper;

    @Lazy
    @Autowired
    private CompleteMapper completeMapper;

    @Lazy
    @Autowired
    private FriendsMapper friendsMapper;

    public Users toEntity(UsersDto dto){
        return Users.builder()
                .name(dto.getName())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phoneNumber(dto.getPhoneNumber())
                .birthDate(dto.getBirthDate())
                .joinedDate(dto.getJoinedDate())
                .courseTaken(dto.getCourseTaken())
                .build();
    }

    public UsersDto toDto(Users users) {
        return UsersDto.builder()
                .SSN(users.getSSN())
                .name(users.getName())
                .username(users.getUsername())
                .email(users.getEmail())
                .password(users.getPassword())
                .phoneNumber(users.getPhoneNumber())
                .joinedDate(users.getJoinedDate())
                .birthDate(users.getBirthDate())
                .createdAt(users.getCreatedAt())
                .updatedAt(users.getUpdatedAt())
                .deletedAt(users.getDeletedAt())
                .build();
    }


    public UsersDto toDtoWithAttr(Users users) {
        return UsersDto.builder()
                .SSN(users.getSSN())
                .name(users.getName())
                .username(users.getUsername())
                .email(users.getEmail())
                .password(users.getPassword())
                .phoneNumber(users.getPhoneNumber())
                .joinedDate(users.getJoinedDate())
                .birthDate(users.getBirthDate())
                .courseTaken(users.getCourseTaken())
                .registerId(users.getRegisterId())
                .statisticsId(users.getStatisticsId())
                .completes(users.getCompletes().stream().map(this.completeMapper::toDto).toList())
                .registers(users.getRegisters().stream().map(this.registerMapper::toDto).toList())
                .friends(users.getFriends().stream().map(this.friendsMapper::toDto).toList())
                .statistics(this.statisticsMapper.toDto(users.getStatistics()))
                .friendsFollowers(users.getFriendsFollowers())
                .friendsFollowing(users.getFriendsFollowing())
                .createdAt(users.getCreatedAt())
                .updatedAt(users.getUpdatedAt())
                .deletedAt(users.getDeletedAt())
                .build();
    }

    public Users update(Users users, UsersDto dto){
        if (dto.getName() != null) {
            users.setName(dto.getName());
        }
        if (dto.getUsername() != null) {
            users.setUsername(dto.getUsername());
        }
        if (dto.getEmail() != null) {
            users.setEmail(dto.getEmail());
        }
        if (dto.getPhoneNumber() != null) {
            users.setPhoneNumber(dto.getPhoneNumber());
        }
        if (dto.getPassword() != null) {
            users.setPassword(dto.getPassword());
        }
        return users;
    }
}
