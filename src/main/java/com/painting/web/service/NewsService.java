package com.painting.web.service;

import com.painting.web.dao.GuestBookDao;
import com.painting.web.dao.NewsDao;
import com.painting.web.entity.GuestBook;
import com.painting.web.entity.News;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;


public class NewsService {


    private NewsDao newsDao;

    @Autowired
    public NewsService(NewsDao newsDao) {
        this.newsDao = newsDao;
    }


    public News getById(Integer id) {
        return newsDao.getOne(id);
    }

    /**
     * 分页
     */
    public Page<News> findAll(Integer page, Integer size) {
        Pageable pageable1 = new QPageRequest(page, size);
        return newsDao.findAll(pageable1);
    }


}
