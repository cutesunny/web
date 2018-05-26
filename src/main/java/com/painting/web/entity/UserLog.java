package com.painting.web.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity(name = "user_log")
public class UserLog extends AbstractEntity {
    private String username;
    private String ip;
    private Date time;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
