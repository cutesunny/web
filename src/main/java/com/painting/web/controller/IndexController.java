package com.painting.web.controller;

import com.painting.web.entity.User;
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

    @GetMapping(value = "/")
    public String index(HttpSession session){
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
     * 登出
     * @param request
     * @param response
     */
    @GetMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect("/");
    }
}
