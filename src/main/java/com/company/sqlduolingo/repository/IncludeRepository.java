package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Include;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IncludeRepository extends JpaRepository<Include, Integer> {

    Optional<Include> findIncludeByIncludeIdAndDeletedAtIsNull(Integer includeId);
}
