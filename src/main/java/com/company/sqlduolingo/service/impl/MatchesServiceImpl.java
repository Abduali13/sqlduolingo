package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.MatchesDto;
import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.entity.Matches;
import com.company.sqlduolingo.repository.MatchesRepository;
import com.company.sqlduolingo.service.MatchesService;
import com.company.sqlduolingo.service.mapper.MatchesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MatchesServiceImpl implements MatchesService {

    private final MatchesRepository matchesRepository;
    private final MatchesMapper matchesMapper;

    @Override
    public ResponseDto<MatchesDto> create(MatchesDto dto) {
        try {
            Matches entity = this.matchesMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<MatchesDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.matchesMapper.toDto(
                                    this.matchesRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<MatchesDto>builder()
                    .code(-2)
                    .message(String.format("Card error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<MatchesDto> get(Integer matchesId) {
        Optional<Matches> optional = this.matchesRepository.findMatchesByMatchIdAndDeletedAtIsNull(matchesId);
        if (optional.isEmpty()) {
            return ResponseDto.<MatchesDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", matchesId))
                    .build();
        }
        return ResponseDto.<MatchesDto>builder()
                .success(true)
                .message("OK")
                .content(this.matchesMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<MatchesDto> update(Integer matchesId, MatchesDto dto) {
        Optional<Matches> optional = this.matchesRepository.findMatchesByMatchIdAndDeletedAtIsNull(matchesId);
        if (optional.isEmpty()) {
            return ResponseDto.<MatchesDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", matchesId))
                    .build();
        }
        return ResponseDto.<MatchesDto>builder()
                .success(true)
                .message("OK")
                .content(this.matchesMapper.toDto(
                                this.matchesRepository.save(
                                        this.matchesMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<MatchesDto> delete(Integer matchesId) {
        Optional<Matches> optional = this.matchesRepository.findMatchesByMatchIdAndDeletedAtIsNull(matchesId);
        if (optional.isEmpty()) {
            return ResponseDto.<MatchesDto>builder()
                    .code(-1)
                    .message(String.format("Card with %d id is not found", matchesId))
                    .build();
        }
        Matches matches = optional.get();
        matches.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<MatchesDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.matchesMapper.toDto(
                                this.matchesRepository.save(matches))
                ).build();
    }
}
