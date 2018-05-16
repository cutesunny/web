package com.painting.web.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 评论
 */
@Entity(name = "comment")
public class Comment extends AbstractEntity{

    public static final Integer CALLIGRAPHY = 1;
    public static final Integer PAINTING = 2;

    @Column(name = "material_id")
    private Integer materialId;
    private String content;
    private Integer star;
    private String username;

    @Column(name = "create_time")
    private Date createTime;

    private String type;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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
