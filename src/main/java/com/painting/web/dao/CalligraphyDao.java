package com.painting.web.dao;

import com.painting.web.entity.Calligraphy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//书法
@Repository
public interface CalligraphyDao extends JpaRepository<Calligraphy, Integer> {


    Page<Calligraphy> findAllByTypeOrderByIdDesc(Integer type, Pageable pageable);


    List<Calligraphy> findAllByTypeOrderByIdAsc(Integer type);

    Calligraphy findTopById(Integer id);

    @Override
    @Query(value = "select * from calligraphy where type != 0", nativeQuery = true)
    List<Calligraphy> findAll();

    @Query(value = "SELECT  * from  calligraphy where title like concat('%',?1,'%') limit 1", nativeQuery = true)
    Calligraphy search(String key);
}
