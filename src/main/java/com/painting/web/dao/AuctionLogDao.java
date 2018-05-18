package com.painting.web.dao;

import com.painting.web.entity.Auction;
import com.painting.web.entity.AuctionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wangxiaodong on 2018/5/17.
 */
@Repository
public interface AuctionLogDao extends JpaRepository<AuctionLog,Integer>{

    AuctionLog findTopByAuctionOrderByTimeDesc(Auction auction);

}
