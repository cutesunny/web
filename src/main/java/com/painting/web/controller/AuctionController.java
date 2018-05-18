package com.painting.web.controller;

import com.painting.web.entity.Auction;
import com.painting.web.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 竞拍
 */
@Controller
@RequestMapping(value = "/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping
    public String auction(Model model){
        model.addAttribute("data1", auctionService.page(Auction.SHUFA,1,4).getContent());
        model.addAttribute("data2", auctionService.page(Auction.GUOHUA,1,4).getContent());
        model.addAttribute("data3", auctionService.page(Auction.YOUHUA,1,4).getContent());
        model.addAttribute("data4", auctionService.page(Auction.BANHUA,1,4).getContent());
        model.addAttribute("data5", auctionService.page(Auction.SHUIFEN,1,4).getContent());
        model.addAttribute("data6", auctionService.page(Auction.YISHUPING,1,4).getContent());
        return "auction";
    }
    @GetMapping(value = "/{id}")
    public String detail(@PathVariable Integer id, Model model){
        model.addAttribute("auction", auctionService.getOne(id));
        return "auction_detail";
    }
    @GetMapping(value = "/list")
    public String list(Integer type ,Integer pageNum, Integer pageSize){
        return "auction_list";
    }
}
