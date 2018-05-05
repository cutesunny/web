package com.painting.web.dao;

import com.painting.web.entity.Calligraphy;
import com.painting.web.entity.Painting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//作品
@Repository
public interface PaintingDao extends JpaRepository<Painting, Integer> {


   //@Query(value = "select p FROM Painting p WHERE p.type = :type")
    Page<Painting> findAllByTypeOrderByIdAsc(@Param("type") String type, Pageable pageable);





/*    @Query(value = "select p.* FROM painting p WHERE p.type = :type",
    countQuery = "select count(*) FROM painting p WHERE p.type = :type",
    nativeQuery = true)
    Page<Painting> findAllByType(@Param("type") Integer type, Pageable pageable);*/




    @Override
    Painting getOne(Integer integer);
}
