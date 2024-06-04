package com.company.sqlduolingo.service.impl;

import com.company.sqlduolingo.dto.ResponseDto;
import com.company.sqlduolingo.dto.StatisticsDto;
import com.company.sqlduolingo.entity.Statistics;
import com.company.sqlduolingo.repository.StatisticsRepository;
import com.company.sqlduolingo.service.StatisticsService;
import com.company.sqlduolingo.service.mapper.StatisticsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final StatisticsRepository statisticsRepository;
    private final StatisticsMapper statisticsMapper;

    @Override
    public ResponseDto<StatisticsDto> create(StatisticsDto dto) {
        try {
            Statistics entity = this.statisticsMapper.toEntity(dto);
            entity.setCreatedAt(LocalDateTime.now());
            return ResponseDto.<StatisticsDto>builder()
                    .success(true)
                    .message("OK")
                    .content(
                            this.statisticsMapper.toDto(
                                    this.statisticsRepository.save(
                                            entity
                                    )
                            )
                    ).build();

        } catch (Exception e) {
            return ResponseDto.<StatisticsDto>builder()
                    .code(-2)
                    .message(String.format("Statistics error while saving; message :: %s", e.getMessage())).build();
        }
    }

    @Override
    public ResponseDto<StatisticsDto> get(Integer statisticsId) {
        Optional<Statistics> optional = this.statisticsRepository.findStatisticsByStatisticsIdAndDeletedAtIsNull(statisticsId);
        if (optional.isEmpty()) {
            return ResponseDto.<StatisticsDto>builder()
                    .code(-1)
                    .message(String.format("Statistics with %d id is not found", statisticsId))
                    .build();
        }
        return ResponseDto.<StatisticsDto>builder()
                .success(true)
                .message("OK")
                .content(this.statisticsMapper.toDto(optional.get())).build();
    }

    @Override
    public ResponseDto<StatisticsDto> update(Integer statisticsId, StatisticsDto dto) {
        Optional<Statistics> optional = this.statisticsRepository.findStatisticsByStatisticsIdAndDeletedAtIsNull(statisticsId);
        if (optional.isEmpty()) {
            return ResponseDto.<StatisticsDto>builder()
                    .code(-1)
                    .message(String.format("Statistics with %d id is not found", statisticsId))
                    .build();
        }
        return ResponseDto.<StatisticsDto>builder()
                .success(true)
                .message("OK")
                .content(this.statisticsMapper.toDto(
                                this.statisticsRepository.save(
                                        this.statisticsMapper.update(
                                                optional.get(), dto
                                        )
                                )
                        )
                )
                .build();
    }

    @Override
    public ResponseDto<StatisticsDto> delete(Integer statisticsId) {
        Optional<Statistics> optional = this.statisticsRepository.findStatisticsByStatisticsIdAndDeletedAtIsNull(statisticsId);
        if (optional.isEmpty()) {
            return ResponseDto.<StatisticsDto>builder()
                    .code(-1)
                    .message(String.format("Statistics with %d id is not found", statisticsId))
                    .build();
        }
        Statistics statistics = optional.get();
        statistics.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<StatisticsDto>builder()
                .success(true)
                .message("OK")
                .content(
                        this.statisticsMapper.toDto(
                                this.statisticsRepository.save(statistics))
                ).build();
    }
}
