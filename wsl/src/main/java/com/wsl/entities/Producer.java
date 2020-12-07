package com.wsl.entities;

import java.util.Date;

public class Producer {

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

    public Producer(Integer id, String Name, Integer password) {
        super();
        this.id = id;
        this.name = Name;
        this.password=password;
    }

    public Producer() {
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", password" + password +
                '}';
    }


}
