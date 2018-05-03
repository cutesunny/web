package com.painting.web.service;

import com.painting.web.dao.CalligraphyDao;
import com.painting.web.entity.Calligraphy;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

@Service
public class CalligraphyService {


    @Autowired
    private CalligraphyDao calligraphyDao;



    public ResponseVO<Calligraphy> getById(Integer id) {
        Calligraphy calligraphy = calligraphyDao.getOne(id);
        ResponseVO<Calligraphy> responseEntity = new ResponseVO<>();
        responseEntity.setData(calligraphy);
        return responseEntity;
    }

    /**
     * 分页
     */
    public ResponseVO<Page<Calligraphy>> findAll(Integer page, Integer size) {
        ResponseVO<Page<Calligraphy>> responseEntity = new ResponseVO<>();
        responseEntity.setCode(200);
        Pageable pageable1 = new QPageRequest(page, size);
        Page<Calligraphy> images = calligraphyDao.findAll(pageable1);
        responseEntity.setData(images);
        return responseEntity;
    }


}
