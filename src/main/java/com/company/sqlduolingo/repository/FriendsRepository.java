package com.company.sqlduolingo.repository;

import com.company.sqlduolingo.entity.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, Integer> {

    Optional<Friends> findFriendsByFriendIdAndDeletedAtIsNull(Integer friendsId);

}
