package com.wsl.dao;

import com.wsl.entities.Game;
import com.wsl.entities.Order;
import com.wsl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderDao {

    private static Map<Integer, Order> orders = null;


    static{
        orders = new HashMap<Integer, Order>();
        orders.put(1, new Order(1, 1001,1001,1,new Date()));
        orders.put(2, new Order(2, 1002,1002,1,new Date()));
        orders.put(3, new Order(3, 1002,1003,2,new Date()));
        orders.put(4, new Order(4, 1003,1003,2,new Date()));


    }

    private static Integer initId = 5;

    public void save(Order order){
        if(order.getId() == null){
            order.setId(initId++);
        }
        orders.put(order.getId(), order);
    }

    //查询所有员工
    public Collection<Order> getAll(){
        return orders.values();
    }

    public Order get(Integer id){
        return orders.get(id);
    }

    public void delete(Integer id){
        orders.remove(id);
    }
}
