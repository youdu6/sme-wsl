package com.wsl.dao;

import com.wsl.entities.Cart;
import com.wsl.entities.Comment;
import com.wsl.entities.Game;
import com.wsl.entities.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CommentDao {

    private static Map<Integer, Comment> comments = null;


    static{
        comments = new HashMap<Integer, Comment>();
        comments.put(1001, new Comment(1001,"刘希", "lol","有丶东西",new Date()));
        comments.put(1002, new Comment(1002,"刘希", "b","有丶东西",new Date()));
        comments.put(1003, new Comment(1003,"孙立飞", "c","有丶东西",new Date()));
        comments.put(1004, new Comment(1004,"王新宇", "a","有丶东西",new Date()));
    }

    private static Integer initId = 1005;

    public void save(Comment comment){
        if(comment.getId() == null){
            comment.setId(initId++);
        }
        comments.put(comment.getId(), comment);
    }

    //查询所有员工
    public Collection<Comment> getAll(){
        return comments.values();
    }

    public Comment get(Integer id){
        return comments.get(id);
    }

    public void delete(Integer id){
        comments.remove(id);
    }

//    public Collection<Game> getBypName(String pName){
//        Map<Integer, Game> newGames = null;
//        newGames=new HashMap<Integer, Game>();
//        int count=0;
//        for (Game game: this.getAll()){
//            if (game.getpName().equals(pName)){
//                newGames.put(count++,game);
//            }
//        }
//        return newGames.values();
//    }
}
