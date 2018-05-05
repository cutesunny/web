package com.painting.web.dao;

import com.painting.web.entity.Calligraphy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//书法
@Repository
public interface CalligraphyDao extends JpaRepository<Calligraphy, Integer> {


    Page<Calligraphy> findAllByTypeOrderByIdAsc(@Param("type") String type, Pageable pageable);

    @Override
    Page<Calligraphy> findAll(Pageable pageable);


    @Override
    Calligraphy getOne(Integer id);
}
