package com.painting.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "article")
public class Article extends AbstractEntity{

    public static final int RECENTLY_EXHIBITION = 1;//近期展会
    public static final int GALLERY = 2;//画廊
    public static final int ONLINE = 3;//在线展览
    public static final int INDEX_DATA = 4;//首页数据

    private String title;
    private String thumb;
    private String description;
    private String content;
    private Integer type;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
