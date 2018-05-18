package com.painting.web.api;

import com.painting.web.entity.Auction;
import com.painting.web.entity.IException;
import com.painting.web.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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
     * 竞拍
     * @param id
     */
    @PostMapping(value = "/order")
    public void order(Integer id, HttpSession session) throws IException {
        auctionService.order(id, session);
    }
}
