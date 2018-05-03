package com.painting.web.dao;

import com.painting.web.entity.Calligraphy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//作品
public interface CalligraphyDao extends JpaRepository<Calligraphy, Integer> {

    @Override
    Page<Calligraphy> findAll(Pageable pageable);




    @Override
    Calligraphy getOne(Integer integer);
}
