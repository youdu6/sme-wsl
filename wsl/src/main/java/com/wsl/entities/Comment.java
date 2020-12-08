package com.wsl.entities;

import java.util.Date;

public class Comment {
    private Integer id;
    private String uName;
    private String gName;
    private String content;
    private Date date;

    public Comment(Integer id, String uName, String gName, String content, Date date) {
        this.id = id;
        this.uName = uName;
        this.gName=gName;
        this.content = content;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
