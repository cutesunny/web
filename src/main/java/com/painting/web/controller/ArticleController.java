package com.painting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章
 */
@Controller
@RequestMapping(value = "/article")
public class ArticleController {


    @GetMapping(value = "/list")
    public String list(Integer type, Integer pageNo, Integer pageSize){
        return "/article_list";
    }

    @GetMapping(value = "/{id}")
    public String news(@PathVariable Integer id){
        return "article";
    }
}
