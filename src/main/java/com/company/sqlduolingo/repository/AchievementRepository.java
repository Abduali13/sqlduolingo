package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Integer> {

    Optional<Achievement> findAchievementByAchievementIdAndDeletedAtIsNull(Integer achievementId);

}
