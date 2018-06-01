package com.painting.web.controller;

import com.painting.web.entity.Auction;
import com.painting.web.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 用户中心
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private AuctionService auctionService;


    @GetMapping(value = "/auction/list")
    public String list(HttpSession session, Model model){
        model.addAttribute("datas",auctionService.findAllByUsername(session));
        return "my-auction";
    }
}
