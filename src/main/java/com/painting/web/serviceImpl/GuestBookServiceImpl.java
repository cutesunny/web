package com.painting.web.serviceImpl;

import com.painting.web.dao.GuestBookDao;
import com.painting.web.entity.GuestBook;
import com.painting.web.entity.ResponseEntity;
import com.painting.web.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

@Service
public class GuestBookServiceImpl implements GuestBookService{


    private GuestBookDao guestBookDao;

    @Autowired
    public GuestBookServiceImpl(GuestBookDao guestBookDao) {
        this.guestBookDao = guestBookDao;
    }

    @Override
    public ResponseEntity<GuestBook> getById(Integer id) {
        GuestBook guestBook = guestBookDao.getById(id);
        ResponseEntity<GuestBook> responseEntity = new ResponseEntity<>();
        responseEntity.setData(guestBook);
        return responseEntity;
    }

    /**
     * 分页
     */
    @Override
    public ResponseEntity<Page<GuestBook>> findAll(Integer page, Integer size) {
        ResponseEntity<Page<GuestBook>> responseEntity = new ResponseEntity<>();
        responseEntity.setCode(200);
        Pageable pageable1 = new QPageRequest(page, size);
        Page<GuestBook> guestBooks = guestBookDao.findAll(pageable1);
        responseEntity.setData(guestBooks);
        return responseEntity;
    }

    /**
     * 保存
     */
    @Override
    public ResponseEntity<String> save(GuestBook guestBook) {
         guestBookDao.saveAndFlush(guestBook);
        return new ResponseEntity<>(200);
    }
}
