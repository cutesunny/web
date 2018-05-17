package com.painting.web.controller;

import com.painting.web.entity.News;
import com.painting.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 新闻
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping
    public String news(Model model){
        model.addAttribute("data1", newsService.findAll(News.FLASH,1 ,5).getContent());
        model.addAttribute("data2", newsService.findAll(News.FOCUS,1 ,2).getContent());
        model.addAttribute("data3", newsService.findAll(News.ART,1 ,2).getContent());
        model.addAttribute("data4", newsService.findAll(News.ARTIST,1 ,3).getContent());
        return "news";
    }

    @GetMapping(value = "/list")
    public String list(Integer type, Integer pageNo, Integer pageSize, Model model){
        model.addAttribute("page", newsService.findAll(type, pageNo, pageSize));
        model.addAttribute("type", type);
        return "news_list";
    }

    @GetMapping(value = "/{id}")
    public String news(@PathVariable Integer id, Model model){
        model.addAttribute("news", newsService.getById(id));
        return "news_detail";
    }
}
