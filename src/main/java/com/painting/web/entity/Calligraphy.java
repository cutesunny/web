package com.painting.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 书法
 */
@Entity(name = "calligraphy")
public class Calligraphy extends AbstractEntity{

    public static final Integer INDEX_DATA = 0;
    /**
     * 行书
     */
    public static final Integer XING_SHU = 1;
    /**
     * 草书
     */
    public static final Integer CAO_SHU = 2;
    /**
     * 楷书
     */
    public static final Integer KAI_SHU = 3;

    private String path;
    private String title;
    private String description;
    private String content;
    private String type;
    /**
     * 评论数量
     */
    @Column(name = "comment_amount")
    private Integer commentAmount;

    public Integer getCommentAmount() {
        return commentAmount;
    }

    public void setCommentAmount(Integer commentAmount) {
        this.commentAmount = commentAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
