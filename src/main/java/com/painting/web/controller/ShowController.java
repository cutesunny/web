package com.painting.web.controller;

import com.painting.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 展览
 */
@Controller
@RequestMapping(value = "/show")
public class ShowController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public String show(Model model) {
        articleService.setShowData(model);
        return "/show";
    }


    @GetMapping(value = "/{id}")
    public String detail(@PathVariable Integer id){
        return"/show_detail";
    }

    @GetMapping(value = "/list")
    public String list(Integer type, Integer pageSize, Integer pageNo){
        return"/show_list";
    }
}
