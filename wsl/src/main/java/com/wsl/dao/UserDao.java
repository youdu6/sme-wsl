package com.wsl.dao;

import com.wsl.entities.Game;
import com.wsl.entities.User;
import com.wsl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Repository
public class UserDao {

    @Autowired
    UserMapper userMapper;

    private static Map<Integer, User> users = null;
    private static User[] newUsers=null;
    static{
        users = new HashMap<Integer, User>();
        users.put(1, new User(1, "刘希",123456));
        users.put(2, new User(2, "孙立飞",123456));
        users.put(3, new User(3, "王新宇",123456));

    }

    private static Integer initId = 4;

    public void save(User user){
        if(user.getId() == null){
            user.setId(initId++);
            userMapper.insertUser(user);
        }else userMapper.updateUser(user);
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
        userMapper.deleteUserById(id);
        users.remove(id);
    }
}
