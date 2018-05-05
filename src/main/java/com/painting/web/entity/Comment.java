package com.painting.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * 图片评论
 */
@Entity(name = "comment")
public class Comment extends AbstractEntity{

    public static final Integer CALLIGRAPHY = 1;
    public static final Integer PAINTING = 1;

    @Column(name = "material_id")
    private Integer materialId;
    private String comment;
    private Integer star;
    private String username;

    @Column(name = "create_time")
    private String createTime;

    private String type;


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

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
