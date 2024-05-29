package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.FIGGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FIGGameRepository extends JpaRepository<FIGGame, Integer> {

    Optional<FIGGame> findFIGByFigIdAndDeletedAtIsNull(Integer figId);

}
