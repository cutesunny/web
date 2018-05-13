package com.painting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 竞拍
 */
@Controller
@RequestMapping(value = "/auction")
public class AuctionController {

    @GetMapping
    public String auction(){
        return "/auction";
    }
    @GetMapping(value = "/{id}")
    public String detail(@PathVariable Integer id){
        return "/auction_detail";
    }
    @GetMapping(value = "/list")
    public String list(Integer type ,Integer pageNum, Integer pageSize){
        return "/auction_list";
    }
}
