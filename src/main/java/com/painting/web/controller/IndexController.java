package com.painting.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页,留言板
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(){
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
}
