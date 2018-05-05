package com.painting.web.service;

import com.painting.web.dao.GuestBookDao;
import com.painting.web.entity.GuestBook;
import com.painting.web.vo.ResponseVO;
import com.painting.web.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

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
        Pageable pageable1 = new QPageRequest(page, size);
        return guestBookDao.findAll(pageable1);
    }

    /**
     * 保存
     */
    public void save(GuestBook guestBook) {
        guestBookDao.saveAndFlush(guestBook);
    }
}
