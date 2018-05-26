package com.painting.web.controller;

import com.painting.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private GuestBookService guestBookService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserLogService userLogService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CalligraphyService calligraphyService;
    @Autowired
    private PaintingService paintingService;
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
    public String userList(Model model){
        model.addAttribute("users",userService.findAll());
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

    @GetMapping(value = "/user/{id}")
    public String userInfo(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "admin/user-info";
    }
    /**
     * 用户浏览记录
     * @return
     */
    @GetMapping(value = "/user-log")
    public String userRecordBrowse(Model model){
        model.addAttribute("logs", userLogService.findAll());
        return "admin/user-log";
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
     * 评论管理
     * @return
     */
    @GetMapping(value = "/comment-mgr")
    public String commentMgr(Model model){
        model.addAttribute("comments", commentService.findAll());
        return "admin/comment";
    }
    /**
     * 欢迎
     * @return
     */
    @GetMapping(value = "/welcome")
    public String welcome(){
        return "admin/welcome";
    }
    /**
     * 书法
     * @return
     */
    @GetMapping(value = "/calligraphy-list")
    public String calligraphyList(Model model){
        model.addAttribute("datas", calligraphyService.findAll());
        return "admin/calligraphy-list";
    }
    /**
     * 绘画
     * @return
     */
    @GetMapping(value = "/painting-list")
    public String paintingList(Model model){
        model.addAttribute("datas", paintingService.findAll());
        return "admin/painting-list";
    }
}
