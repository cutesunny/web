package com.painting.web.service;

import com.painting.web.dao.CommentDao;
import com.painting.web.entity.Comment;
import com.painting.web.entity.IException;
import com.painting.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by wangxiaodong on 2018/5/16.
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    /**
     * 评论
     * @param comment
     * @param session
     */
    public void insert(Comment comment, HttpSession session) throws IException {
        User user = (User)session.getAttribute("user");
        if(user == null){
            throw new IException("你还没有登陆");
        }
        comment.setUsername(user.getUsername());
        comment.setCreateTime(new Date());
        commentDao.save(comment);
    }

    /**
     * 评论分页
     * @param type
     * @param materialId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<Comment> page(Integer type, Integer materialId, Integer pageNum, Integer pageSize){
        pageNum=pageNum==null?1:pageNum;
        pageSize=pageSize==null?10:pageSize;
        Pageable pageable = new QPageRequest(pageNum-1, pageSize);
        Page<Comment> page = commentDao.findAllByTypeAndMaterialId(type.toString(), materialId, pageable);
        return page;
    }
}
