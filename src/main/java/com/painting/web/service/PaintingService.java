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



    public Painting getById(Integer id) {
        return paintingDao.getOne(id);
    }

    /**
     * 分页
     */
    public Page<Painting> findAll(Integer pageNum, Integer size) {
        Pageable pageable1 = new QPageRequest(pageNum, size);
        return  paintingDao.findAll(pageable1);
    }


}
