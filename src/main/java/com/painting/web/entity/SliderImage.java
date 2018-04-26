package com.painting.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 首页轮播图
 */
@Table(name = "slider_image")
@Entity
public class SliderImage {
    private Integer id;
    private String path;

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
}
