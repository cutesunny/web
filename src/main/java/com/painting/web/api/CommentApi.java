package com.painting.web.api;

import com.painting.web.entity.Comment;
import com.painting.web.entity.IException;
import com.painting.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id){
        commentService.delete(id);
    }
}
