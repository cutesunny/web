package com.painting.web.service;

import com.painting.web.dao.GalleryDao;
import com.painting.web.dao.NewsDao;
import com.painting.web.entity.Gallery;
import com.painting.web.entity.News;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {


    private GalleryDao galleryDao;

    @Autowired
    public GalleryService(GalleryDao galleryDao) {
        this.galleryDao = galleryDao;
    }


    public ResponseVO<Gallery> getById(Integer id) {
        Gallery gallery = galleryDao.getOne(id);
        ResponseVO<Gallery> responseEntity = new ResponseVO<>();
        responseEntity.setData(gallery);
        return responseEntity;
    }

    /**
     * 分页
     */
    public ResponseVO<Page<Gallery>> findAll(Integer page, Integer size) {
        ResponseVO<Page<Gallery>> responseEntity = new ResponseVO<>();
        responseEntity.setCode(200);
        Pageable pageable1 = new QPageRequest(page, size);
        Page<Gallery> galleries = galleryDao.findAll(pageable1);
        responseEntity.setData(galleries);
        return responseEntity;
    }


}
