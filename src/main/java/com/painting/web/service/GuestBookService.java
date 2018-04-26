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


    public ResponseVO<GuestBook> getById(Integer id) {
        GuestBook guestBook = guestBookDao.getById(id);
        ResponseVO<GuestBook> responseEntity = new ResponseVO<>();
        responseEntity.setData(guestBook);
        return responseEntity;
    }

    /**
     * 分页
     */
    public ResponseVO<Page<GuestBook>> findAll(Integer page, Integer size) {
        ResponseVO<Page<GuestBook>> responseEntity = new ResponseVO<>();
        responseEntity.setCode(200);
        Pageable pageable1 = new QPageRequest(page, size);
        Page<GuestBook> guestBooks = guestBookDao.findAll(pageable1);
        responseEntity.setData(guestBooks);
        return responseEntity;
    }

    /**
     * 保存
     */
    public ResponseVO<String> save(GuestBook guestBook) {
         guestBookDao.saveAndFlush(guestBook);
        return new ResponseVO<>(200);
    }
}
