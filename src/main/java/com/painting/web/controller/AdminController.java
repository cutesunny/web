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
     * 用户列表
     * @return
     */
    @GetMapping(value = "/user-list")
    public String userList(Model model, Integer pageNo){
        model.addAttribute("page",userService.page(pageNo));
        return "admin/user-list";
    }


    @GetMapping(value = "/user/{id}")
    public String userInfo(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "admin/user-info";
    }
    /**
     * 用户登陆记录
     * @return
     */
    @GetMapping(value = "/user-log-list")
    public String userRecordBrowse(Model model, Integer pageNo){
        model.addAttribute("page", userLogService.page(pageNo));
        return "admin/user-log-list";
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
    @GetMapping(value = "/guest-book-list")
    public String contactUs(Integer pageNo,  Model model){
        model.addAttribute("page", guestBookService.page(pageNo));
        return "admin/guest-book-list";
    }
    /**
     * 评论管理
     * @return
     */
    @GetMapping(value = "/comment-list")
    public String commentList(Integer pageNo,  Model model){
        model.addAttribute("page", commentService.page(pageNo));
        return "admin/comment-list";
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
     * 书法列表
     * @return
     */
    @GetMapping(value = "/calligraphy-list")
    public String calligraphyList(Integer pageNo,  Model model){
        model.addAttribute("page", calligraphyService.page(pageNo));
        return "admin/calligraphy-list";
    }
    /**
     * 书法添加
     * @return
     */
    @GetMapping(value = "/calligraphy-add")
    public String addCalligraphy(){
        return "admin/calligraphy-add";
    }
    /**
     * 书法编辑
     * @return
     */
    @GetMapping(value = "/calligraphy/{id}")
    public String updateCalligraphy(@PathVariable Integer id, Model model){
        model.addAttribute("data", calligraphyService.getById(id));
        return "admin/calligraphy-update";
    }
    /**
     * 绘画列表
     * @return
     */
    @GetMapping(value = "/painting-list")
    public String paintingList(Integer pageNo,  Model model){
        model.addAttribute("page", paintingService.page(pageNo));
        return "admin/painting-list";
    }
    /**
     * 绘画添加
     * @return
     */
    @GetMapping(value = "/painting-add")
    public String addPainting(){
        return "admin/painting-add";
    }
    /**
     * 绘画编辑
     * @return
     */
    @GetMapping(value = "/painting/{id}")
    public String updatePainting(@PathVariable Integer id, Model model){
        model.addAttribute("data", paintingService.getById(id));
        return "admin/painting-update";
    }
}
