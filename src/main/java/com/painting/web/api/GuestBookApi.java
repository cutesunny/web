
package com.painting.web.api;

import com.painting.web.vo.ResponseVO;
import com.painting.web.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 留言板
 */
@RestController
@RequestMapping(value = "/api/guestBook")
public class GuestBookApi {

    private GuestBookService guestBookServiceImpl;

    @Autowired
    public GuestBookApi(GuestBookService guestBookServiceImpl) {
        this.guestBookServiceImpl = guestBookServiceImpl;
    }

    @RequestMapping(value = "/")
    public ResponseVO getById(HttpServletResponse response){
        return guestBookServiceImpl.getById(1);
    }
}
