package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findUsersBySSNAndDeletedAtIsNull(Integer ssn);

    List<Users> findAllByDeletedAtIsNull();

}
