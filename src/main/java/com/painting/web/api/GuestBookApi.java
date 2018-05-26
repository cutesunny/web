
package com.painting.web.api;

import com.painting.web.entity.GuestBook;
import com.painting.web.vo.ResponseVO;
import com.painting.web.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 留言板
 */
@RestController
@RequestMapping(value = "/api/guest-book")
public class GuestBookApi {

    private GuestBookService guestBookServiceImpl;

    @Autowired
    public GuestBookApi(GuestBookService guestBookServiceImpl) {
        this.guestBookServiceImpl = guestBookServiceImpl;
    }

    @PostMapping
    public void add(GuestBook guestBook){
        guestBookServiceImpl.save(guestBook);
    }
    @GetMapping
    public GuestBook getById(HttpServletResponse response){
        return guestBookServiceImpl.getById(1);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable  Integer id){
        guestBookServiceImpl.delete(id);
    }
}
