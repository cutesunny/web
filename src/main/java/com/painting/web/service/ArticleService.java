package com.painting.web.service;

import com.painting.web.dao.ArticleDao;
import com.painting.web.entity.Article;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;



    public ResponseVO<Article> getById(Integer id) {
        Article article = articleDao.getOne(id);
        ResponseVO<Article> responseEntity = new ResponseVO<>();
        responseEntity.setData(article);
        return responseEntity;
    }

    /**
     * 分页
     */
    public ResponseVO<Page<Article>> findAll(Integer page, Integer size) {
        ResponseVO<Page<Article>> responseEntity = new ResponseVO<>();
        responseEntity.setCode(200);
        Pageable pageable1 = new QPageRequest(page, size);
        Page<Article> articles = articleDao.findAll(pageable1);
        responseEntity.setData(articles);
        return responseEntity;
    }


}
