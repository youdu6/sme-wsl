package com.wsl.dao;

import com.wsl.entities.*;
import com.wsl.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class NoticeDao {

    @Autowired
    NoticeMapper noticeMapper;
    private static Map<Integer, Notice> notices= null;


    static{
        notices = new HashMap<Integer, Notice>();
        notices.put(1, new Notice(1, "lxnb"));
        notices.put(2, new Notice(2,"slfnb"));
        notices.put(3, new Notice(3, "wxycb"));

    }

    private static Integer initId = 4;

    public void save(Notice notice){
        if(notice.getId() == null){
            notice.setId(initId++);
            noticeMapper.insertNotice(notice);
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
        noticeMapper.deleteNoticeById(id);
        notices.remove(id);
    }
}
