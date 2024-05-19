package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Worksheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorksheetRepository extends JpaRepository<Worksheet, Integer> {

    Optional<Worksheet> findWorksheetByWorksheetIdAndDeletedAtIsNull(Integer worksheetId);

}
