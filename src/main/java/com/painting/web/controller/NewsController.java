package com.painting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 新闻
 */
@Controller
@RequestMapping(value = "/news")
public class NewsController {

    @GetMapping()
    public String news(){
        return "news";
    }

    @GetMapping(value = "/list")
    public String list(Integer type, Integer pageNo, Integer pageSize){
        return "/news_list";
    }

    @GetMapping(value = "/{id}")
    public String news(@PathVariable Integer id){
        return "news";
    }
}
