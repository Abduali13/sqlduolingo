package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.MultipleQuestionGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MultipleQuestionGameRepository extends JpaRepository<MultipleQuestionGame, Integer> {

    Optional<MultipleQuestionGame> findWorksheetByWorksheetIdAndDeletedAtIsNull(Integer worksheetId);

}
