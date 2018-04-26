package com.painting.web.dao;

import com.painting.web.entity.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//作品
public interface ImageDao extends JpaRepository<Image, Integer> {

    @Override
    Page<Image> findAll(Pageable pageable);

    @Override
    Image getOne(Integer integer);
}
