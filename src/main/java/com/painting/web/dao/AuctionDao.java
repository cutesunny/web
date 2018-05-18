package com.painting.web.dao;

import com.painting.web.entity.Auction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by wangxiaodong on 2018/5/17.
 */
@Repository
public interface AuctionDao extends JpaRepository<Auction, Integer>{


    Page<Auction> findAllByTypeAndStatusOrderByIdDesc(Integer type,Integer status, Pageable pageable);

    /**
     * find one
     * @param id
     * @return
     */
    Auction findTopById(Integer id);


    /**
     * 列出超时的商品
     * @return
     */
    @Query(value = "SELECT * FROM auction WHERE end_time <= CURRENT_TIMESTAMP() AND status = 1", nativeQuery = true)
    List<Auction> findAllWithTimeOut();
    /**
     * 增加当前价格
     * @param id
     * @return
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "update auction set current_price = current_price + increase_price  where id = ?1", nativeQuery = true)
    int increaseCurrentPriceById(Integer id);

    /**
     * 设置状态
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "update auction set status = ?2  where id = ?1", nativeQuery = true)
    int setSttus(Integer id, Integer status);
}
