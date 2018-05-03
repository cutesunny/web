package com.painting.web.dao;

import com.painting.web.entity.Calligraphy;
import com.painting.web.entity.Painting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//作品
public interface PaintingDao extends JpaRepository<Painting, Integer> {

    @Override
    Page<Painting> findAll(Pageable pageable);




    @Override
    Painting getOne(Integer integer);
}
