package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    Optional<Course> findCourseByCourseIdAndDeletedAtIsNull(Integer courseId);

    Optional<Course> findCourseByCourseNameAndDeletedAtIsNull(String courseName);

}
