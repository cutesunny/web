package com.painting.web.service;

import com.painting.web.dao.ArticleDao;
import com.painting.web.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;



    public Article getById(Integer id) {
        return articleDao.getOne(id);
    }

    /**
     * 分页
     */
    public Page<Article> findAll(Integer page, Integer size, Integer type) {
        Pageable pageable1 = new QPageRequest(page-1, size);
        return articleDao.findAllByTypeOrderByIdDesc(type.toString(), pageable1);
    }


}
