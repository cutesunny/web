package com.painting.web.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by wangxiaodong on 2018/5/14.
 */
@Entity(name = "auction")
public class Auction extends AbstractEntity{

    /**
     *  书法
     */
    public static final Integer SHUFA = 1;
    /**
     *  国画
     */
    public static final Integer GUOHUA = 2;
    /**
     *  油画
     */
    public static final Integer YOUHUA = 3;
    /**
     *  版画
     */
    public static final Integer BANHUA = 4;
    /**
     *  水粉
     */
    public static final Integer SHUIFEN = 5;
    /**
     *  艺术品
     */
    public static final Integer YISHUPING = 6;


    private String title;
    private String thumb;
    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<AuctionPic> pics;

    @OneToMany(cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<AuctionLog> logs;
    /**
     * 底价
     */
    @Column(name = "base_price")
    private Double basePrice;
    /**
     * 保证金
     */
    private Double deposit;
    /**
     * 当前价格
     */
    @Column(name = "current_price")
    private Double currentPrice;
    /**
     * 加幅价
     */
    @Column(name = "increase_price")
    private Double increasePrice;
    /**
     * 时长
     */
    @Column(name = "end_time")
    private Date endTime;
    /**
     * 介绍
     */
    private String content;

    /**
     * 类型
     * @return
     */
    public Integer type;

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuctionPic> getPics() {
        return pics;
    }

    public void setPics(List<AuctionPic> pics) {
        this.pics = pics;
    }

    public List<AuctionLog> getLogs() {
        return logs;
    }

    public void setLogs(List<AuctionLog> logs) {
        this.logs = logs;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getIncreasePrice() {
        return increasePrice;
    }

    public void setIncreasePrice(Double increasePrice) {
        this.increasePrice = increasePrice;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
