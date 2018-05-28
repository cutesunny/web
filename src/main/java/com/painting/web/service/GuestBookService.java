package com.painting.web.service;

import com.painting.web.dao.GuestBookDao;
import com.painting.web.entity.GuestBook;
import com.painting.web.entity.User;
import com.painting.web.vo.ResponseVO;
import com.painting.web.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GuestBookService{


    private GuestBookDao guestBookDao;

    @Autowired
    public GuestBookService(GuestBookDao guestBookDao) {
        this.guestBookDao = guestBookDao;
    }


    public GuestBook getById(Integer id) {
        return guestBookDao.getById(id);
    }

    /**
     * 分页
     */
    public Page<GuestBook> findAll(Integer page, Integer size) {
        Pageable pageable1 = new QPageRequest(page-1, size);
        return guestBookDao.findAll(pageable1);
    }

    /**
     * 保存
     */
    public void save(GuestBook guestBook) {
        guestBook.setTime(new Date());
        guestBookDao.saveAndFlush(guestBook);
    }
    public void delete(Integer id){
        guestBookDao.deleteById(id);;
    }


    public Page<GuestBook> page(Integer pageNo) {
        pageNo=pageNo==null?1:pageNo;
        Integer pageSize = 10;
        Pageable pageable1 =  PageRequest.of(pageNo-1, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<GuestBook> page;
        page = guestBookDao.findAll(pageable1);
        return page;
    }
}
