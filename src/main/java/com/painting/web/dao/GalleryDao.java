package com.painting.web.dao;

import com.painting.web.entity.Gallery;
import com.painting.web.entity.Image;
import com.painting.web.entity.ImageComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 展馆
 */
@Repository
public interface GalleryDao extends JpaRepository<Gallery, Integer> {

    @Override
    Page<Gallery> findAll(Pageable pageable);
}
