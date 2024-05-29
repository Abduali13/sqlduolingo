package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Exercise;
import com.company.sqlduolingo.entity.enums.Level;
import com.company.sqlduolingo.entity.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    Optional<Exercise> findExerciseByExerciseIdAndDeletedAtIsNull(Integer exerciseId);


    @Query(value = "select e from Exercise as e where e.level = :level and e.type = :type", nativeQuery = true)
    Optional<Exercise> findExerciseByLevelAndType(@Param(value = "leve")Level level, @Param(value = "type")Type type);

}
