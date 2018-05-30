package com.painting.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

//绘画
@Entity(name = "painting")
public class Painting extends AbstractEntity{

    private String path;
    private String title;
    private String description;
    private String content;
    @Column(name = "comment_amount")
    private Integer commentAmount;

    public Integer getCommentAmount() {
        return commentAmount;
    }

    public void setCommentAmount(Integer commentAmount) {
        this.commentAmount = commentAmount;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
