package com.wsl.mapper;

import com.wsl.entities.Cart;
import com.wsl.entities.Comment;
import com.wsl.entities.Game;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CartMapper {
//    @Select("select * from 购物车")
//    public Comment[] getAllComment();
//
//    @Select("select * from 评论 where id=#{id}")
//    public Comment getCommentById(Integer id);

    @Delete("delete from 购物车游戏 where 游戏编号=#{game.id} and 购物车编号=#{cart.id}")
    public int deleteCartGameById(Cart cart,Game game);

    @Insert("insert into 购物车游戏(购物车编号, 游戏编号) values(#{cart.id},#{game.id})")
    public int insertCartGame(Cart cart, Game game);
//
//    @Update("update 评论 set 购物车编号=#{name}, 用户名=#{type}, 内容=#{content} where id=#{id}")
//    public int updateCartGame(Cart cart);
}
