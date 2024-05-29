package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.MatchesGameDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.MatchesGame;
import com.company.sqlduolingo.repository.MatchesGameRepository;
import com.company.sqlduolingo.service.MatchesGameService;
import com.company.sqlduolingo.service.mapper.MatchesGameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MatchesGameServiceImpl implements MatchesGameService {

    private final MatchesGameRepository matchesGameRepository;
    private final MatchesGameMapper matchesGameMapper;

    @Override
    public ResponseDto<MatchesGameDto> create(MatchesGameDto dto) {
        try {
            MatchesGame entity = this.matchesGameMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<MatchesGameDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.matchesGameMapper.toDto(
                                    this.matchesGameRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<MatchesGameDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<MatchesGameDto> get(Integer matchesId) {
        Optional<MatchesGame> optional = this.matchesGameRepository.findMatchesByMatchIdAndDeletedAtIsNull(matchesId);
        if (optional.isEmpty()) {
            return ResponseDto.<MatchesGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", matchesId))
                    .build();
        }
        return ResponseDto.<MatchesGameDto>builder()
                .success(true)
                .message("OK")
                .content(this.matchesGameMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<MatchesGameDto> update(Integer matchesId, MatchesGameDto dto) {
        Optional<MatchesGame> optional = this.matchesGameRepository.findMatchesByMatchIdAndDeletedAtIsNull(matchesId);
        if (optional.isEmpty()) {
            return ResponseDto.<MatchesGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", matchesId))
                    .build();
        }
        return ResponseDto.<MatchesGameDto>builder()
                .success(true)
                .message("OK")
                .content(this.matchesGameMapper.toDto(
                                this.matchesGameRepository.save(
                                        this.matchesGameMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<MatchesGameDto> delete(Integer matchesId) {
        Optional<MatchesGame> optional = this.matchesGameRepository.findMatchesByMatchIdAndDeletedAtIsNull(matchesId);
        if (optional.isEmpty()) {
            return ResponseDto.<MatchesGameDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", matchesId))
                    .build();
        }
        MatchesGame matchesGame = optional.get();
        matchesGame.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<MatchesGameDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.matchesGameMapper.toDto(
                                this.matchesGameRepository.save(matchesGame))
                ).build();
    }
}
