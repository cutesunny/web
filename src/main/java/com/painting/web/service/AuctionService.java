package com.painting.web.service;

import com.painting.web.dao.AuctionDao;
import com.painting.web.dao.AuctionLogDao;
import com.painting.web.entity.Auction;
import com.painting.web.entity.AuctionLog;
import com.painting.web.entity.IException;
import com.painting.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by wangxiaodong on 2018/5/17.
 */
@Service
public class AuctionService {

    @Autowired
    private AuctionDao auctionDao;
    @Autowired
    private AuctionLogDao logDao;

    public Page<Auction> page(Integer type, Integer pageNo, Integer pageSize){
        pageNo=pageNo==null?1:pageNo;
        pageSize=pageSize==null?8:pageSize;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        if(type == null){
            return auctionDao.findAll(pageable);
        }else{
            return auctionDao.findAllByTypeAndStatusOrderByIdDesc(type,Auction.NORMAL,pageable);
        }
    }

    public Auction getOne(Integer id){
        Auction auction = auctionDao.findTopById(id);
        return auction;
    }

    /**
     * 竞拍
     * @param id
     * @param session
     */
    @Transactional(rollbackOn = Exception.class)
    public void order(Integer id, HttpSession session) throws IException {
        User user = (User) session.getAttribute("user");
        if(user == null){
            throw new IException("你还没有登陆");
        }
        AuctionLog log = new AuctionLog();
        Auction auction = auctionDao.findTopById(id);
        if(auction== null || auction.getStatus().equals(Auction.DONE)){
            throw new IException("商品已卖出");
        }
        AuctionLog tmpLog = logDao.findTopByAuctionOrderByTimeDesc(auction);
        if(tmpLog != null && tmpLog.getUsername().equals(user.getUsername())){
            throw new IException("目前你排第一位,无需再竞拍");
        }
        log.setAuction(auction);
        log.setPrice(auction.getCurrentPrice());
        log.setTime(new Date());
        log.setUsername(user.getUsername());
        //更改竞品当前价格
        auctionDao.increaseCurrentPriceById(id);
        //保存竞拍记录
        logDao.save(log);
    }

    public void add(Auction auction){
        auction.setStatus(Auction.NORMAL);
        auction.setCurrentPrice(auction.getBasePrice());
        auctionDao.save(auction);
    }

    public void update(Auction auction){
        Auction _auction = auctionDao.findTopById(auction.getId());
        auction.setStatus(_auction.getStatus());
        auction.setCurrentPrice(_auction.getCurrentPrice());
        auctionDao.save(auction);
    }
    public List<AuctionLog> findAllByUsername(HttpSession session){
        User user = (User)session.getAttribute("user");
        return logDao.findAllByUsername(user.getUsername());
    }
    public void delete(Integer id){
        auctionDao.deleteById(id);
    }
}
