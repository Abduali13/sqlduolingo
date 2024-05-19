package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchesRepository extends JpaRepository<Matches, Integer> {

    Optional<Matches> findMatchesByMatchIdAndDeletedAtIsNull(Integer matchId);

}
