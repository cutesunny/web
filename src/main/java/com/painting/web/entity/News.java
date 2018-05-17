package com.painting.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 新闻
 */
@Entity(name = "news")
public class News extends AbstractEntity{


    /**
     * 焦点
     */
    public static final Integer FOCUS = 1;
    /**
     * 艺术
     */
    public static final Integer ART = 2;
    /**
     * 艺术家
     */
    public static final Integer ARTIST = 3;
    /**
     * 快讯
     */
    public static final Integer FLASH = 4;

    //标题
    private String title;
    //作者
    private String author;
    //封面
    private String thumb;
    //简介
    private String description;
    //内容
    private String content;

    /**
     * 类型
     * @return
     */
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
