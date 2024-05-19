package com.company.sqlduolingo.service.mapper;

import com.company.sqlduolingo.dto.FriendsDto;
import com.company.sqlduolingo.entity.Friends;
import org.springframework.stereotype.Component;

@Component
public class FriendsMapper {

    public Friends toEntity(FriendsDto dto){
        return Friends.builder()
                .follower(dto.getFollower())
                .following(dto.getFollowing())
                .build();
    }

    public FriendsDto toDto(Friends friends){
        return FriendsDto.builder()
                .friendId(friends.getFriendId())
                .SSN(friends.getSSN())
                .follower(friends.getFollower())
                .following(friends.getFollowing())
                .createdAt(friends.getCreatedAt())
                .updatedAt(friends.getUpdatedAt())
                .deletedAt(friends.getDeletedAt())
                .build();
    }

    public Friends update(Friends friends, FriendsDto dto){
        if (dto.getFollowing() != null){
            friends.setFollowing(dto.getFollowing());
        }
        if (dto.getFollower() != null){
            friends.setFollower(dto.getFollower());
        }
        return friends;
    }

}
