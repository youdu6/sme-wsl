package com.wsl.dao;

import com.wsl.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class NoticeDao {

    private static Map<Integer, Notice> notices= null;


    static{
        notices = new HashMap<Integer, Notice>();
        notices.put(1001, new Notice(1001, "lxnb"));
        notices.put(1002, new Notice(1002,"slfnb"));
        notices.put(1003, new Notice(1003, "wxycb"));

    }

    private static Integer initId = 1004;

    public void save(Notice notice){
        if(notice.getId() == null){
            notice.setId(initId++);
        }
        notices.put(notice.getId(), notice);
    }

    //查询所有员工
    public Collection<Notice> getAll(){
        return notices.values();
    }

    public Notice get(Integer id){
        return notices.get(id);
    }

    public void delete(Integer id){
        notices.remove(id);
    }
}
