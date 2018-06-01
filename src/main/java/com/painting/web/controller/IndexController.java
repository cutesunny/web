package com.painting.web.controller;

import com.painting.web.entity.Auction;
import com.painting.web.entity.User;
import com.painting.web.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 首页,留言板
 */
@Controller
public class IndexController {

    @Autowired
    private AuctionService auctionService;


    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("auctions", auctionService.page(null, 1, 8).getContent());
        return "index";
    }

    /**
     * 联系我们
     * @return
     */
    @GetMapping(value = "/contact-us")
    public String contact(){
        return "contact_us";
    }
    /**
     * 分享
     * @return
     */
    @GetMapping(value = "/share")
    public String share(){
        return "share";
    }

    /**
     * 登出
     * @param request
     * @param response
     */
    @GetMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        session.removeAttribute("user");
        response.sendRedirect(request.getHeader("referer"));
    }
}
