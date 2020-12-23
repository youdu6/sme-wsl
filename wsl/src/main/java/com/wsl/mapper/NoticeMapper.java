package com.wsl.mapper;

import com.wsl.entities.Notice;
import com.wsl.entities.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {

    @Delete("delete from 公告 where id=#{id}")
    public int deleteNoticeById(Integer id);

    @Insert("insert into 公告(内容) values(#{content})")
    public int insertNotice(Notice notice);
}
