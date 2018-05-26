package com.painting.web.entity;

import javax.persistence.Entity;

@Entity(name = "user")
public class User extends AbstractEntity{

    /**
     * 专家
     */
    public static final int NORMAL = 1;

    /**
     * 专家
     */
    public static final int SPECIALIST = 2;

    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
