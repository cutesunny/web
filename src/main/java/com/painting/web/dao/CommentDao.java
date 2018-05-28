package com.painting.web.dao;

import com.painting.web.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//评论
@Repository
public interface CommentDao extends JpaRepository<Comment, Integer>{

    /**
     * 查找评论
     * @param  type
     * @param materialId
     * @return
     */
    Page<Comment> findAllByTypeAndMaterialId(Integer type, Integer materialId, Pageable pageable);


}
