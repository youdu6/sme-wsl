package com.wsl.entities;

import java.util.Date;

public class Admin {

    private Integer id;
    private String name;
    private Integer password;

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

    public Admin(Integer id, String Name, Integer password) {
        super();
        this.id = id;
        this.name = Name;
        this.password=password;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", password" + password +
                '}';
    }


}
