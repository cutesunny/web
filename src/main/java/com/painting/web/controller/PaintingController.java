package com.painting.web.controller;

import com.painting.web.entity.Comment;
import com.painting.web.service.CommentService;
import com.painting.web.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 绘画
 */
@Controller
@RequestMapping(value = "/painting")
public class PaintingController {

    @Autowired
    private PaintingService service;

    @Autowired
    private CommentService commentService;
    /**
     * 绘画
     * @param model
     * @return
     */
    @GetMapping
    public String index(Model model){
        model.addAttribute("newPainting", service.findAll(1, 8));
        model.addAttribute("hotPainting", service.findHotTop8());
        return "painting";
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public String index(@PathVariable Integer id, Model model) {
        model.addAttribute("item", service.getById(id));
        return "painting_detail";
    }

    @GetMapping(value = "/list")
    public String list(Integer pageNum, Integer pageSize, Model model){
        model.addAttribute("page", service.findAll(pageNum, pageSize));
        return "painting_list";
    }

    /**
     * 评论列表
     * @param id
     * @param pageNum
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping(value = "/{id}/comment-list")
    public String commentList(@PathVariable Integer id, Integer pageNum, Integer pageSize,Model model){
        model.addAttribute("data", service.getById(id));
        model.addAttribute("comments", commentService.page(Comment.CALLIGRAPHY, id, pageNum, pageSize ));
        return "comment";
    }
}
