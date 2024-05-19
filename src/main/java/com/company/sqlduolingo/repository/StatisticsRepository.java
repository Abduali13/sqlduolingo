package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {

    Optional<Statistics> findStatisticsByStatisticsIdAndDeletedAtIsNull(Integer statisticsId);

}
