package com.painting.web.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 竞品相册
 * Created by wangxiaodong on 2018/5/17.
 */
@Entity(name = "auction_pic")
public class AuctionPic extends AbstractEntity{

    private String  path;
    private Integer rank;

//    @ManyToOne
//    @JoinColumn(name = "auction_id")
    private Auction auction;



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
