package com.painting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 绘画
 */
@Controller
public class PaintingController {

    //绘画
    @GetMapping(value = "/")
    public String index(){
        return "/painting";
    }
    //详情
    @GetMapping(value = "/{id}")
    public String index(@PathVariable Integer id){
        return "/painting_detail";
    }

    @GetMapping(value = "/list")
    public String list(Integer type, Integer pageNum, Integer pageSize){
        return "/painting_list";
    }
}
