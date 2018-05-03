package com.painting.web.service;

import com.painting.web.dao.CalligraphyDao;
import com.painting.web.dao.PaintingDao;
import com.painting.web.entity.Calligraphy;
import com.painting.web.entity.Painting;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

@Service
public class PaintingService {


    @Autowired
    private PaintingDao paintingDao;



    public ResponseVO<Painting> getById(Integer id) {
        Painting painting = paintingDao.getOne(id);
        ResponseVO<Painting> responseEntity = new ResponseVO<>();
        responseEntity.setData(painting);
        return responseEntity;
    }

    /**
     * 分页
     */
    public ResponseVO<Page<Painting>> findAll(Integer page, Integer size) {
        ResponseVO<Page<Painting>> responseEntity = new ResponseVO<>();
        responseEntity.setCode(200);
        Pageable pageable1 = new QPageRequest(page, size);
        Page<Painting> images = paintingDao.findAll(pageable1);
        responseEntity.setData(images);
        return responseEntity;
    }


}
