package com.painting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 展览
 */
@Controller
@RequestMapping(value = "/show")
public class ShowController {

    @GetMapping()
    public String show() {
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
