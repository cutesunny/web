package com.painting.web.dao;

import com.painting.web.entity.Calligraphy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//书法
@Repository
public interface CalligraphyDao extends JpaRepository<Calligraphy, Integer> {


    Page<Calligraphy> findAllByTypeOrderByIdDesc(@Param("type") String type, Pageable pageable);


    List<Calligraphy> findAllByTypeOrderByIdAsc(String type);

    @Override
    Calligraphy getOne(Integer id);
}
