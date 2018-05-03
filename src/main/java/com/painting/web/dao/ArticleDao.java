package com.painting.web.dao;

import com.painting.web.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 展馆
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

    @Override
    Page<Article> findAll(Pageable pageable);
}
