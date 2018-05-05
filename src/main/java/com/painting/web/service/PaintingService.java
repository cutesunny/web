package com.painting.web.service;

import com.painting.web.dao.CalligraphyDao;
import com.painting.web.dao.PaintingDao;
import com.painting.web.entity.Calligraphy;
import com.painting.web.entity.Painting;
import com.painting.web.vo.ResponseVO;
import com.querydsl.core.types.OrderSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PagesPerMinute;
import java.util.List;

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
    public Page<Painting> findAll(Integer pageNum, Integer pageSize, Integer type) {
        //OrderSpecifier sort = new OrderSpecifier(Sort.Direction.ASC, "id");
        Pageable pageable1 = new QPageRequest(pageNum-1, pageSize);
        return paintingDao.findAllByTypeOrderByIdAsc(type.toString(), pageable1);
    }


}
