package com.painting.web.dao;

import com.painting.web.entity.ImageComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//评论
public interface ImageCommentDao extends JpaRepository<ImageComment, Integer>{

    //查找评论
    List<ImageComment> findByImageId(Integer imageId);

}
