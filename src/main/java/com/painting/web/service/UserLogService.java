package com.painting.web.service;

import com.painting.web.dao.UserDao;
import com.painting.web.dao.UserLogDao;
import com.painting.web.entity.IException;
import com.painting.web.entity.User;
import com.painting.web.entity.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserLogService {

    @Autowired
    private UserLogDao userLogDao;

    public List<UserLog> findAll(){
        return userLogDao.findAll();
    }

    public void delete(Integer id) {
        userLogDao.deleteById(id);
    }
}
