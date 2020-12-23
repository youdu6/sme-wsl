package com.wsl.mapper;

import com.wsl.entities.Game;
import com.wsl.entities.Order;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper {
//    @Select("select * from 游戏")
//    public Game[] getAllGame();
//
//    @Select("select * from 游戏 where id=#{id}")
//    public Game getGameById(Integer id);

    @Delete("delete from 订单 where id=#{id}")
    public int deleteOrderById(Integer id);

    @Insert("insert into 订单(用户, 游戏编号, 时间) values(#{uName},#{gid},#{purchaseDate})")
    public int insertOrder(Order order);

//    @Update("update 游戏 set 名称=#{name}, 类型=#{type}, 生产商=#{pName} where id=#{id}")
//    public int updateGame(Game game);
}
