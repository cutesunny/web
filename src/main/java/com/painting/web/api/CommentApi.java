package com.painting.web.api;

import com.painting.web.entity.Comment;
import com.painting.web.entity.IException;
import com.painting.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by wangxiaodong on 2018/5/16.
 */
@RestController
@RequestMapping(value = "/api/comment")
public class CommentApi {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public void comment(Comment comment, HttpSession session) throws IException {
        commentService.insert(comment, session);
    }
}
