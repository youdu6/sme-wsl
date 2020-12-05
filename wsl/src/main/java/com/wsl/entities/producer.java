package com.wsl.entities;

import java.util.Date;

public class producer {

    private Integer id;
    private String name;
    private Integer password;
    private Integer telephone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String lastName) {
        this.name = lastName;
    }
    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
    public Integer getTelephone(){return telephone;}
    public void setTelephone(Integer telephone){this.telephone=telephone;}

    public producer(Integer id, String Name, Integer password) {
        super();
        this.id = id;
        this.name = Name;
        this.password=password;
    }

    public producer() {
    }

    @Override
    public String toString() {
        return "producer{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", password" + password +
                '}';
    }


}
