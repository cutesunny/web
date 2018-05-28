package com.painting.web.service;

import com.painting.web.dao.UserDao;
import com.painting.web.dao.UserLogDao;
import com.painting.web.entity.Comment;
import com.painting.web.entity.IException;
import com.painting.web.entity.User;
import com.painting.web.entity.UserLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<UserLog> page(Integer pageNo) {
        pageNo=pageNo==null?1:pageNo;
        Integer pageSize = 10;
        Pageable pageable1 =  PageRequest.of(pageNo-1, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<UserLog> page;
        page = userLogDao.findAll(pageable1);
        return page;
    }
}
