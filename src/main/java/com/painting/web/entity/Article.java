package com.painting.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "article")
public class Article extends AbstractEntity{

    public static final String RECENTLY_EXHIBITION = "1";//近期展会
    public static final String GALLERY = "2";//画廊
    public static final String ONLINE = "3";//在线展览
    public static final String INDEX_DATA = "4";//首页数据

    private String title;
    private String thumb;
    private String description;
    private String content;
    private String type;

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
