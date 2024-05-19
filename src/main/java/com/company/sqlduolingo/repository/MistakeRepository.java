package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Mistake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MistakeRepository extends JpaRepository<Mistake, Integer> {

    Optional<Mistake> findMistakeByMistakeIdAndDeletedAtIsNull(Integer mistakeId);

}
