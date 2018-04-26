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

@Service
public class NewsService {


    private NewsDao newsDao;

    @Autowired
    public NewsService(NewsDao newsDao) {
        this.newsDao = newsDao;
    }


    public ResponseVO<News> getById(Integer id) {
        News news = newsDao.getOne(id);
        ResponseVO<News> responseEntity = new ResponseVO<>();
        responseEntity.setData(news);
        return responseEntity;
    }

    /**
     * 分页
     */
    public ResponseVO<Page<News>> findAll(Integer page, Integer size) {
        ResponseVO<Page<News>> responseEntity = new ResponseVO<>();
        responseEntity.setCode(200);
        Pageable pageable1 = new QPageRequest(page, size);
        Page<News> news = newsDao.findAll(pageable1);
        responseEntity.setData(news);
        return responseEntity;
    }


}
