package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

    Optional<Section> findSectionBySectionIdAndDeletedAtIsNull(Integer sectionId);

}
