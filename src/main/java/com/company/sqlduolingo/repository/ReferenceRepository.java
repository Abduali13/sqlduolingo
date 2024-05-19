package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReferenceRepository extends JpaRepository<Reference, Integer> {

    Optional<Reference> findReferenceByReferenceIdAndDeletedAtIsNull(Integer referenceId);

}
