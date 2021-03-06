package com.painting.web.service;

import com.painting.web.dao.UserDao;
import com.painting.web.dao.UserLogDao;
import com.painting.web.entity.Calligraphy;
import com.painting.web.entity.IException;
import com.painting.web.entity.User;
import com.painting.web.entity.UserLog;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserLogDao userLogDao;
    /**
     * 注册
     * @param user
     * @return
     */
    public void register(User user) throws IException {
        if(userDao.findByUsername(user.getUsername()) != null){
            throw new IException("用户已存在");
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
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
        if(username !=null && password != null){
            User user = userDao.findByUsername(username);
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            if(user != null && password.equals(user.getPassword())){
                session.setAttribute("user", user);
                UserLog userLog = new UserLog();
                userLog.setIp("127.0.0.1");
                userLog.setUsername(user.getUsername());
                userLog.setTime(new Date());
                userLogDao.save(userLog);
            }else{
                throw new IException("用户名或密码错误");
            }
        }

    }

    public User findById(Integer id){
        return userDao.findTopById(id);
    }
    public List<User> findAll(){
        return userDao.findAll();
    }

    public void delete(Integer id){
        userDao.deleteById(id);
    }

    @Transactional
    public void update(Integer id, String phone, String email, Integer type) {
        userDao.update(id, phone, email, type);
    }

    public Page<User> page(Integer pageNo) {
        pageNo=pageNo==null?1:pageNo;
        Integer pageSize = 10;
        Pageable pageable1 =  PageRequest.of(pageNo-1, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<User> page;
        page = userDao.findAll(pageable1);
        return page;
    }
}
