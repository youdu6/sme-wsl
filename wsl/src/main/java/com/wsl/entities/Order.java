package com.wsl.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Integer id;
    private Integer uid;
    private String uName;
    private Integer gid;
    private String gName;
    private Integer pid;
    private String pName;
    private String type;
    private Date purchaseDate;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUid(){return uid;}
    public void setUid(Integer uid){this.uid=uid;}
    public Integer getGid(){return gid;}
    public void setGid(Integer gid){this.gid=gid;}
    public Integer getPid(){return pid;}
    public void setPid(Integer pid){this.pid=pid;}
    public Date getPurchaseDate(){return purchaseDate;}
    public void setPurchaseDate(Date purchaseDate){this.purchaseDate=purchaseDate;}

    public Order(Integer id, String uName,Integer uid, String gName,Integer gid, Integer pid, String pName, Date purchaseDate,String type) {
        super();
        this.uName=uName;
        this.gName=gName;
        this.id = id;
        this.uid=uid;
        this.gid=gid;
        this.pid=pid;
        this.pName=pName;
        this.purchaseDate=purchaseDate;
        this.type=type;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", gid" + gid + '\'' +
                ",pid"+ pid+'\''+
                ",purchaseDate"+purchaseDate+'\''+
                '}';
    }


}
