package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.FriendsDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Friends;
import com.company.sqlduolingo.repository.FriendsRepository;
import com.company.sqlduolingo.service.FriendsService;
import com.company.sqlduolingo.service.mapper.FriendsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FriendsServiceImpl implements FriendsService {

    private final FriendsRepository friendsRepository;
    private final FriendsMapper friendsMapper;

    @Override
    public ResponseDto<FriendsDto> create(FriendsDto dto) {
        try {
            Friends entity = this.friendsMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<FriendsDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.friendsMapper.toDto(
                                    this.friendsRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<FriendsDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<FriendsDto> get(Integer friendsId) {
        Optional<Friends> optional = this.friendsRepository.findFriendsByFriendIdAndDeletedAtIsNull(friendsId);
        if (optional.isEmpty()) {
            return ResponseDto.<FriendsDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", friendsId))
                    .build();
        }
        return ResponseDto.<FriendsDto>builder()
                .success(true)
                .message("OK")
                .content(this.friendsMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<FriendsDto> update(Integer friendsId, FriendsDto dto) {
        Optional<Friends> optional = this.friendsRepository.findFriendsByFriendIdAndDeletedAtIsNull(friendsId);
        if (optional.isEmpty()) {
            return ResponseDto.<FriendsDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", friendsId))
                    .build();
        }
        return ResponseDto.<FriendsDto>builder()
                .success(true)
                .message("OK")
                .content(this.friendsMapper.toDto(
                                this.friendsRepository.save(
                                        this.friendsMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<FriendsDto> delete(Integer friendsId) {
        Optional<Friends> optional = this.friendsRepository.findFriendsByFriendIdAndDeletedAtIsNull(friendsId);
        if (optional.isEmpty()) {
            return ResponseDto.<FriendsDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", friendsId))
                    .build();
        }
        Friends friends = optional.get();
        friends.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<FriendsDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.friendsMapper.toDto(
                                this.friendsRepository.save(friends))
                ).build();
    }
}
