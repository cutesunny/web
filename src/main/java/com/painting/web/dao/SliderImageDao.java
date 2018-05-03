package com.painting.web.dao;

import com.painting.web.entity.SliderImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 幻灯片
 */
@Repository
public interface SliderImageDao extends JpaRepository<SliderImage, Integer> {

    @Override
    List<SliderImage> findAll();
}
