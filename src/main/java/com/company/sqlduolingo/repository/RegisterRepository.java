package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {

    Optional<Register> findRegisterByRegisterIdAndDeletedAtIsNull(Integer registerId);


    @Query("SELECT COUNT(r) > 0 FROM Register r " +
            "JOIN Include i ON r.course.courseId = i.course.courseId " +
            "WHERE r.users.SSN = :userId AND i.exercise.exerciseId = :exerciseId")
    boolean existsByUserIdAndExerciseId(Integer userId, Integer exerciseId);

}
