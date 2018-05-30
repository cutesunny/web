package com.painting.web.controller;

import com.painting.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
    @Autowired
    private SliderImageService sliderImageService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private AuctionService auctionService;

    @GetMapping(value = "/index")
    public String index(){
        return "admin/index";
    }

    /**
     * 退出
     * @return
     */
    @GetMapping(value = "/logout")
    public void logout(HttpServletResponse response, HttpSession session) throws IOException {
        session.removeAttribute("admin");
        response.sendRedirect("/admin/login");
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
    /**
     * 文章列表
     * @param model
     * @return
     */
    @GetMapping(value = "/article-list")
    public String articleList(Integer pageNo,Model model){
        model.addAttribute("page", articleService.pageAll(pageNo, 10));
        return "admin/article-list";
    }
    /**
     * 文章添加
     * @return
     */
    @GetMapping(value = "/article-add")
    public String addArticle(){
        return "admin/article-add";
    }
    /**
     * 文章编辑
     * @return
     */
    @GetMapping(value = "/article/{id}")
    public String updateArticle(@PathVariable Integer id, Model model){
        model.addAttribute("data", articleService.getById(id));
        return "admin/article-update";
    }
    /**
     * 新闻列表
     * @param model
     * @return
     */
    @GetMapping(value = "/news-list")
    public String newsList(Integer pageNo,Model model){
        model.addAttribute("page", newsService.findAll(null, pageNo, 10));
        return "admin/news-list";
    }
    /**
     * 新闻添加
     * @return
     */
    @GetMapping(value = "/news-add")
    public String addNews(){
        return "admin/news-add";
    }
    /**
     * 新闻编辑
     * @return
     */
    @GetMapping(value = "/news/{id}")
    public String updateNews(@PathVariable Integer id, Model model){
        model.addAttribute("data", newsService.getById(id));
        return "admin/auction-update";
    }
    /**
     * 商品列表
     * @param model
     * @return
     */
    @GetMapping(value = "/auction-list")
    public String auctionList(Integer pageNo,Model model){
        model.addAttribute("page", auctionService.page(null, pageNo, 10));
        return "admin/auction-list";
    }
    /**
     *商品添加
     * @return
     */
    @GetMapping(value = "/auction-add")
    public String addAuction(){
        return "admin/auction-add";
    }
    /**
     * 商品编辑
     * @return
     */
    @GetMapping(value = "/auction/{id}")
    public String updateAuction(@PathVariable Integer id, Model model){
        model.addAttribute("data", auctionService.getOne(id));
        return "admin/auction-update";
    }
    /**
     * 轮播图
     * @param model
     * @return
     */
    @GetMapping(value = "/slider-image-list")
    public String sliderImage(Model model){
        model.addAttribute("datas", sliderImageService.findAll());
        return "admin/slider-image-list";
    }

}
