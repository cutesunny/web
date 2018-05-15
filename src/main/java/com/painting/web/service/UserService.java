package com.painting.web.service;

import com.painting.web.dao.UserDao;
import com.painting.web.entity.IException;
import com.painting.web.entity.User;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 注册
     * @param user
     * @return
     */
    public void register(User user){
        user.setPassword(MD5Encoder.encode(user.getPassword().getBytes()));
        userDao.save(user);
    }

    /**
     * 登陆
     * @param username
     * @param password
     * @param session
     * @throws IException
     */
    public void login(String username, String password, HttpSession session) throws IException {
        User user = userDao.findByUsername(username);
        password = MD5Encoder.encode(password.getBytes());
        if(password.equals(user.getPassword())){
            session.setAttribute("user", user);
        }else{
            throw new IException("用户名或密码错误");
        }
    }


}
