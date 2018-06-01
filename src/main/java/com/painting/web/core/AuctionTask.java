package com.painting.web.core;

import com.painting.web.dao.AuctionDao;
import com.painting.web.dao.AuctionLogDao;
import com.painting.web.entity.Auction;
import com.painting.web.entity.AuctionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 定时器,
 * Created by wangxiaodong on 2018/5/18.
 */
@Component
public class AuctionTask {

    @Autowired
    private AuctionDao auctionDao;
    @Autowired
    private AuctionLogDao auctionLogDao;
    /**
     * 每隔三十秒,判断商品是否结束,计算最终竞拍成功的用户
     */
    @Scheduled(initialDelay = 5000,fixedDelay = 30*1000)
    public void task(){
        System.out.println("开始执行:"+new Date());
        List<Auction> auctions = auctionDao.findAllWithTimeOut();
        System.out.println("找到商品:"+auctions.size());
        for(Auction auction:auctions){
            System.out.println("处理商品:"+auction.getId());
            AuctionLog log = auctionLogDao.findTopByAuctionOrderByTimeDesc(auction);
            if(log != null){
                //有用户竞拍
                auction.setStatus(Auction.DONE);
                auction.setFinalUsername(log.getUsername());
                auction.setFinalPrice(log.getPrice());
                System.out.println("商品:"+auction.getId()+",拍卖成功,用户名:"+log.getUsername()+", 成交价格:"+log.getPrice());
            }else{
                //没有人竞拍,流拍
                auction.setStatus(Auction.CLOSED);
                System.out.println("商品:"+auction.getId()+",拍卖失败");
            }
            auctionDao.save(auction);
        }
    }
}
