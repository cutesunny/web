package com.painting.web.dao;

import com.painting.web.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 展馆
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {


    Page<Article> findAllByTypeOrderByIdDesc(String type, Pageable pageable);

    List<Article> findAllByTypeOrderByIdAsc(String type);

}
