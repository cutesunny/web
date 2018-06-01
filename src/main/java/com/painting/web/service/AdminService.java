package com.painting.web.service;

import com.painting.web.dao.AdminDao;
import com.painting.web.entity.Admin;
import com.painting.web.entity.IException;
import com.painting.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;


    /**
     * 登陆
     * @param username
     * @param password
     * @param session
     * @throws IException
     */
    public void login(String username, String password, HttpSession session) throws IException {
        if(username !=null && password != null){
            Admin admin = adminDao.findByUsername(username);
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            if(admin != null && password.equals(admin.getPassword())){
                session.setAttribute("admin", admin);
            }else{
                throw new IException("用户名或密码错误");
            }
        }else{
            throw new IException("用户名或密码为空");
        }

    }


}
