package com.wsl.mapper;

import com.wsl.entities.Comment;
import com.wsl.entities.Game;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentMapper {
    @Select("select * from 评论")
    public Comment[] getAllComment();

    @Select("select * from 评论 where id=#{id}")
    public Comment getCommentById(Integer id);

    @Delete("delete from 评论 where id=#{id}")
    public int deleteCommentById(Integer id);

    @Insert("insert into 评论(游戏名称, 用户名, 内容) values(#{gName},#{uName},#{content})")
    public int insertComment(Comment comment);

    @Update("update 评论 set 游戏名称=#{name}, 用户名=#{type}, 内容=#{content} where id=#{id}")
    public int updateComment(Comment comment);
}
