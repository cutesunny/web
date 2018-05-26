package com.painting.web.dao;

import com.painting.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{


    User findByUsername(String username);

    User findTopById(Integer id);

    @Modifying(clearAutomatically = true)
    @Query(value = "update user set phone =?2, email = ?3, type = ?4 where id = ?1", nativeQuery = true)
    Integer update(Integer id, String phone, String email, Integer type);
}
