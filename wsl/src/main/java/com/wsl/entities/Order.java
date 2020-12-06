package com.wsl.entities;

import java.util.Date;

public class Order {

    private Integer id;
    private Integer uid;
    private Integer gid;
    private Integer pid;
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

    public Order(Integer id, Integer uid, Integer gid, Integer pid, Date purchaseDate) {
        super();
        this.id = id;
        this.uid=uid;
        this.gid=gid;
        this.pid=pid;
        this.purchaseDate=purchaseDate;
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
