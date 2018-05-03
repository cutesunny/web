package com.painting.web.api;


import com.painting.web.entity.Article;
import com.painting.web.service.ArticleService;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/article")
public class ArticleApi {

    @Autowired
    private ArticleService galleryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseVO<Page<Article>> getList(Integer page, Integer size){
        return galleryService.findAll(page, size);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseVO<Article> getOne(Integer id){
        return galleryService.getById(id);
    }
}
