package com.company.sqlduolingo.repository;


import com.company.sqlduolingo.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Integer> {

    Optional<Example> findExampleByExampleIdAndDeletedAtIsNull(Integer exampleId);
}
