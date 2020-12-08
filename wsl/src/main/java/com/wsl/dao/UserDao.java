package com.wsl.dao;

import com.wsl.entities.Game;
import com.wsl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private static Map<Integer, User> users = null;


    static{
        users = new HashMap<Integer, User>();
        users.put(1001, new User(1001, "刘希",123456));
        users.put(1002, new User(1002, "孙立飞",123456));
        users.put(1003, new User(1003, "王新宇",123456));

    }

    private static Integer initId = 1004;

    public void save(User user){
        if(user.getId() == null){
            user.setId(initId++);
        }
        users.put(user.getId(), user);
    }

    //查询所有员工
    public Collection<User> getAll(){
        return users.values();
    }

    public User get(Integer id){
        return users.get(id);
    }

    public User getByName(String name){
        for (User user:this.getAll()){
            if (user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }

    public void delete(Integer id){
        users.remove(id);
    }
}
