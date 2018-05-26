package com.painting.web.dao;

import com.painting.web.entity.User;
import com.painting.web.entity.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLogDao extends JpaRepository<UserLog, Integer>{


}
