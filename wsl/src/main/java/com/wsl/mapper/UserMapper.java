package com.wsl.mapper;


import com.wsl.entities.Game;
import com.wsl.entities.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from 用户")
    public User[] getAllUser();

    @Select("select * from 用户 where id=#{id}")
    public User getUserById(Integer id);

    @Delete("delete from 用户 where id=#{id}")
    public int deleteUserById(Integer id);

    @Insert("insert into 用户(用户名, 姓名, 密码) values(#{name},#{name},#{password})")
    public int insertUser(User user);

    @Update("update 用户 set 名称=#{name}, 用户名=#{name}, 密码=#{password} where id=#{id}")
    public int updateUser(User user);
}
