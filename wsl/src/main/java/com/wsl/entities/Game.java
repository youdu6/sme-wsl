package com.wsl.entities;

import java.util.Date;

public class Game {

	private Integer id;
	private Integer pid;
    private String  pName;
    private String name;
    private String type;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getpName(){return pName;}

    public void setpName(String pName){this.pName=pName;}

    public Integer getPid(){return pid;}

    public void setPid(Integer pid){this.pid=pid; }

    public String getType(){return type;}

    public void setType(String type){ this.type=type;}

    public Date getDate(){return date;}

    public void setDate(Date date){this.date=date;}

    public Game(Integer id, Integer pid, String pName, String name, String type, Date date){
        super();
        this.id=id;
        this.pid=pid;
        this.pName=pName;
        this.name=name;
        this.type=type;
        this.date=date;
    }


    public Game() {
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", date=" + date +
                '}';
    }
	
	
}
