package com.painting.web.api;

import com.painting.web.entity.News;
import com.painting.web.entity.Painting;
import com.painting.web.service.NewsService;
import com.painting.web.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 新闻
 */
@RestController
@RequestMapping(value = "/api/news")
public class NewsApi {

    @Autowired
    private NewsService newsService;


    @GetMapping(value = "/list")
    public Page<News> getList(Integer type, Integer pageNum, Integer pageSize){
        return newsService.findAll(type, pageNum, pageSize);
    }

    @GetMapping
    public News getOne(Integer id){
        return newsService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id){
        newsService.delete(id);
    }

    @PostMapping
    public void save(News news) {
        newsService.save(news);
    }

    @PutMapping
    public void update(News news) {
        newsService.save(news);
    }
}
