package com.wsl.dao;

import com.wsl.dao.GameDao;
import com.wsl.entities.Game;
import com.wsl.entities.Order;
import com.wsl.entities.User;
import com.wsl.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDao {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    private static Map<Integer, Order> orders = null;


    static{
        orders = new HashMap<Integer, Order>();
        orders.put(1, new Order(1, "刘希",1001,"a",1,1,"lx",new Date(),"动作"));
        orders.put(2, new Order(2, "孙立飞",1002,"b",2,1,"lx",new Date(),"悬疑"));
        orders.put(3, new Order(3, "孙立飞",1002,"c",3,2,"slf",new Date(),"冒险"));
        orders.put(4, new Order(4, "王新宇",1003,"c",3,2,"slf",new Date(),"冒险"));


    }

    private static Integer initId = 5;

    public void save(Order order){
        order.setPurchaseDate(new Date());
        if(order.getId() == null){
            order.setId(initId++);
            orderMapper.insertOrder(order);
        }
        orders.put(order.getId(), order);
    }

    //查询所有员工
    public Collection<Order> getAll(){
        return orders.values();
    }

    public Collection<Order> getByU(String uName){
        Map<Integer, Order> newOrders = null;
        newOrders=new HashMap<Integer, Order>();
        int count=0;
        for (Order order: this.getAll()){
            if (order.getUName().equals(uName)){
                newOrders.put(count++,order);
            }
        }
        return newOrders.values();
    }

    public Order get(Integer id){
        return orders.get(id);
    }

    public void delete(Integer id){
        orders.remove(id);
    }
}