package com.painting.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

//图片素材,作品等
@Entity
@Table(name = "image")
public class Image {
    public static final int CHUANQI_SHUHUA = 0;
    public static final int DANGDAI_SHUHUA = 1;
    private Integer id;
    private String path;
    private String title;
    private String description;
    private String content;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
