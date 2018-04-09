package com.painting.web.api;

import com.painting.web.dao.GuestBookDao;
import com.painting.web.entity.GuestBook;
import com.painting.web.entity.ResponseEntity;
import com.painting.web.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class GuestBookApi {

    private GuestBookService guestBookServiceImpl;

    @Autowired
    public GuestBookApi(GuestBookService guestBookServiceImpl) {
        this.guestBookServiceImpl = guestBookServiceImpl;
    }

    @RequestMapping(value = "/")
    public ResponseEntity getById(HttpServletResponse response){
        return guestBookServiceImpl.getById(1);
    }
}
