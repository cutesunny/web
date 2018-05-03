package com.painting.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 图片评论
 */
@Entity
@Table(name = "comment")
public class Comment {

    public static final Integer CALLIGRAPHY = 1;
    public static final Integer PAINTING = 1;

    private Integer id;
    @Column(name = "article_id")
    private Integer articleID;
    private String comment;
    private Integer star;
    private String username;

    @Column(name = "create_time")
    private String createTime;

    private String type;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
