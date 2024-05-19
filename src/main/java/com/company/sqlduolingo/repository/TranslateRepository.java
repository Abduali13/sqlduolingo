package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Translate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TranslateRepository extends JpaRepository<Translate, Integer> {

    Optional<Translate> findTranslateByTranslateIdAndDeletedAtIsNull(Integer translateId);

}
