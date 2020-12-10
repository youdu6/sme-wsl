package com.wsl.entities;

import java.util.ArrayList;
import java.util.Date;

public class Cart {
    private Integer id;
    private ArrayList<Game> games;
    private String uName;
    private Integer cnt;

    public Cart(Integer id, ArrayList<Game> games, String uName) {
        this.id = id;
        this.games = games;
        this.uName = uName;

    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }




}
