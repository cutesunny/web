package com.painting.web.api;

import com.painting.web.entity.News;
import com.painting.web.service.NewsService;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新闻
 */
@RestController
@RequestMapping(value = "/api/news")
public class NewsApi {

    @Autowired
    private NewsService newsService;


    @GetMapping(value = "/list")
    public Page<News> getList(Integer type, Integer page, Integer size){
        return newsService.findAll(page, size);
    }

    @GetMapping
    public News getOne(Integer id){
        return newsService.getById(id);
    }
}
