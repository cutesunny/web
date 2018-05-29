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


    public News getById(Integer id) {
        return newsDao.getOne(id);
    }

    /**
     * 分页
     */
    public Page<News> findAll(Integer type, Integer pageNum, Integer pageSize) {
        pageNum=pageNum==null?1:pageNum;
        pageSize=pageSize==null?12:pageSize;
        Pageable pageable1 = new QPageRequest(pageNum-1, pageSize);
        if(type != null){
            return newsDao.findAllByTypeOrderByIdDesc(type, pageable1);
        }else{
            return newsDao.findAll(pageable1);
        }
    }

    /**
     * 删除
     */
    public void delete(Integer id){
        newsDao.deleteById(id);
    }

    public void save(News news) {
        newsDao.save(news);
    }


}
