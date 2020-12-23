package com.wsl.mapper;


import com.wsl.entities.Game;
import com.wsl.entities.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GameMapper {

    @Select("select * from 游戏")
    public Game[] getAllGame();

    @Select("select * from 游戏 where id=#{id}")
    public Game getGameById(Integer id);

    @Delete("delete from 游戏 where id=#{id}")
    public int deleteGameById(Integer id);

    @Insert("insert into 游戏(名称, 类型, 生产商) values(#{name},#{type},#{pName})")
    public int insertGame(Game game);

    @Update("update 游戏 set 名称=#{name}, 类型=#{type}, 生产商=#{pName} where id=#{id}")
    public int updateGame(Game game);
}
