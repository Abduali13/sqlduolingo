package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.TranslateGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TranslateGameRepository extends JpaRepository<TranslateGame, Integer> {

    Optional<TranslateGame> findTranslateByTranslateIdAndDeletedAtIsNull(Integer translateId);

}
