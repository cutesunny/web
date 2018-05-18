package com.painting.web.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 出价记录
 * Created by wangxiaodong on 2018/5/17.
 */
@Entity(name = "auction_log")
public class AuctionLog extends AbstractEntity{

    private String username;
    /**
     * 出价
     */
    private Double price;
    /**
     * 时间
     */
    private Date time;


    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
