package com.wsl.dao;

import com.wsl.entities.Admin;
import com.wsl.entities.Game;
import com.wsl.entities.Producer;
import com.wsl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminDao {

    private static Map<Integer, Admin> admins = null;


    static{
        admins = new HashMap<Integer, Admin>();
        admins.put(1, new Admin(1, "admin",123456));

    }

    private static Integer initId = 2;

    public void save(Admin admin){
        if(admin.getId() == null){
            admin.setId(initId++);
        }
        admins.put(admin.getId(), admin);
    }

    //查询所有员工
    public Collection<Admin> getAll(){
        return admins.values();
    }

    public Admin get(Integer id){
        return admins.get(id);
    }

    public Admin getByName(String name){
        for (Admin admin:this.getAll()){
            if (admin.getName().equals(name)){
                return admin;
            }
        }
        return null;
    }

    public void delete(Integer id){
        admins.remove(id);
    }
}
