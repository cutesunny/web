package com.painting.web.api;

import com.painting.web.entity.Auction;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拍卖
 */
@RestController
@RequestMapping(value = "/api/auction")
public class AuctionApi {

    //列表分页
    @GetMapping(value = "/list")
    public Page<Auction> list(Integer type, Integer pageNum, Integer pageSize){

        return null;
    }
    //详情
    @GetMapping
    public Auction detail(Integer id){

        return null;
    }
}
