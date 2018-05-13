package com.painting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 书法
 */
@Controller
@RequestMapping(value = "/calligraphy")
public class CalligraphyController {


    @GetMapping(value = "/")
    public String index(){
        return "/calligraphy";
    }

    @GetMapping(value = "/{id}")
    public String detail(@PathVariable Integer id){
        return "calligraphy_detail";
    }
    @GetMapping(value = "/list")
    public String list(Integer type, Integer pageNum, Integer pageSize){
        return "/calligraphy_list";
    }
}
