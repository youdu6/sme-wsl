package com.wsl.entities;

import java.util.ArrayList;
import java.util.Date;

public class Cart {
    private Integer id;
    private ArrayList<String> gName;
    private String uName;
    private Date date;

    public Cart(Integer id, ArrayList<String> gName, String uName, Date date) {
        this.id = id;
        this.gName = gName;
        this.uName = uName;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<String> getgName() {
        return gName;
    }

    public void setgName(ArrayList<String> gName) {
        this.gName = gName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }




}
