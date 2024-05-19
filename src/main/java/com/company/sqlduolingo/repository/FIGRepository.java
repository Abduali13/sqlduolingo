package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.FIG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FIGRepository extends JpaRepository<FIG, Integer> {

    Optional<FIG> findFIGByFigIdAndDeletedAtIsNull(Integer figId);

}
