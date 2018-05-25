package com.painting.web.dao;

import com.painting.web.entity.Admin;
import com.painting.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{


    Admin findByUsername(String username);
}
