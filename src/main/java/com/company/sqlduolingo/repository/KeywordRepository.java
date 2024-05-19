package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Integer> {

    Optional<Keyword> findKeywordsByKeywordIdAndDeletedAtIsNull(Integer keywordsId);

    @Query(value = "select k.keyword from Keyword as k order by k.keyword asc", nativeQuery = true)
    List<Keyword> listKeywordsByAscendingOrder();

    @Query(value = "select k.keyword from Keyword as k order by k.keyword desc ", nativeQuery = true)
    List<Keyword> listKeywordsByDesscendingOrder();


}
