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



    public Calligraphy getById(Integer id) {
        Calligraphy calligraphy = calligraphyDao.getOne(id);
        return calligraphy;
    }

    /**
     * 分页
     */
    public Page<Calligraphy> findAll(Integer pageNum, Integer size, Integer type) {
        Pageable pageable1 = new QPageRequest(pageNum-1, size);
        Page<Calligraphy> calligraphyPage;
        if(type == null){
            calligraphyPage = calligraphyDao.findAll(pageable1);
        }else{
            calligraphyPage = calligraphyDao.findAllByTypeOrderByIdAsc(type.toString(), pageable1);
        }
        return calligraphyPage;
    }


}
