package com.painting.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 新闻
 */

public class News extends AbstractEntity{

    /**
     * 焦点
     */
    public static final int FOCUS = 1;
    /**
     * 艺术
     */
    public static final int ART = 2;
    /**
     * 艺术家
     */
    public static final int ARTIST = 2;
    //标题
    private String title;
    //来源
    private String source;
    //作者
    private String author;
    //封面
    private String thumb;
    //简介
    private String introduction;
    //内容
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
