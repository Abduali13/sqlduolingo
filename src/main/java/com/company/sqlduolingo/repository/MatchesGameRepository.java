package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.MatchesGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchesGameRepository extends JpaRepository<MatchesGame, Integer> {

    Optional<MatchesGame> findMatchesByMatchIdAndDeletedAtIsNull(Integer matchId);

}
