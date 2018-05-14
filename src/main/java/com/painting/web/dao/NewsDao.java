package com.painting.web.dao;

import com.painting.web.entity.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 新闻
 */
@Repository
public interface NewsDao extends JpaRepository<News, Integer> {

    @Override
    Page<News> findAll(Pageable pageable);

    Page<News> findAllByTypeOrderByIdDesc(@Param("type") String type, Pageable pageable);

    @Override
    News getOne(Integer integer);
}
