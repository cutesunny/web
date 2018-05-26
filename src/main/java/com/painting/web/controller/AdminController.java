package com.painting.web.controller;

import com.painting.web.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private GuestBookService guestBookService;

    @GetMapping(value = "/index")
    public String index(){
        return "admin/index";
    }

    /**
     * 产品列表
     * @return
     */
    @GetMapping(value = "/product-list")
    public String productMgr(){
        return "admin/product-list";
    }

    /**
     * 用户列表
     * @return
     */
    @GetMapping(value = "/user-list")
    public String userList(){
        return "admin/user-list";
    }

    /**
     * 用户等级
     * @return
     */
    @GetMapping(value = "/user-level")
    public String userLevel(){
        return "admin/user-list";
    }

    /**
     * 用户浏览记录
     * @return
     */
    @GetMapping(value = "/user-record-browse")
    public String userRecordBrowse(){
        return "admin/user-record-browse";
    }

    /**
     * 分享记录
     * @return
     */
    @GetMapping(value = "/user-record-share")
    public String userRecordShare(){
        return "admin/user-record-share";
    }

    /**
     * 登陆
     * @return
     */
    @GetMapping(value = "/login")
    public String login(){
        return "admin/login";
    }
    /**
     * 意见反馈
     * @return
     */
    @GetMapping(value = "/guest-book")
    public String contactUs(Model model){
        model.addAttribute("datas", guestBookService.list());
        return "admin/guest-book";
    }
    /**
     * 欢迎
     * @return
     */
    @GetMapping(value = "/welcome")
    public String welcome(){
        return "admin/welcome";
    }

}
