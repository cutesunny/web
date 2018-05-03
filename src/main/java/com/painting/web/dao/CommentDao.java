package com.painting.web.dao;

import com.painting.web.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//评论
public interface CommentDao extends JpaRepository<Comment, Integer>{

    //查找评论
    List<Comment> findByImageId(Integer imageId);

}
