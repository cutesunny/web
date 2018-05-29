package com.painting.web.api;


import com.painting.web.entity.Article;
import com.painting.web.entity.Calligraphy;
import com.painting.web.service.ArticleService;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/article")
public class ArticleApi {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public List<Article> getList(){
        return articleService.getIndexData();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<Article> getList(Integer pageNo, Integer pageSize, Integer type){
        return articleService.findAll(pageNo, pageSize, type);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object getOne(Integer id){
        return articleService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id){
        articleService.delete(id);
    }

    @PostMapping
    public void add(Article article){
        articleService.save(article);
    }

    @PutMapping
    public void update(Article article){
        articleService.save(article);
    }

}
