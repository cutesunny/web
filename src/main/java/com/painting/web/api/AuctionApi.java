package com.painting.web.api;

import com.painting.web.entity.Auction;
import com.painting.web.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 拍卖
 */
@RestController
@RequestMapping(value = "/api/auction")
public class AuctionApi {

    @Autowired
    private AuctionService auctionService;

    /**
     * 首页接口
     * @return
     */
    @GetMapping(value = "/index-data")
    public List<Auction> getIndexData(){
        return auctionService.page(null, 0, 8).getContent();
    }

}
