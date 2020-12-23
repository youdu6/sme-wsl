package com.wsl.dao;

import com.wsl.entities.Cart;
import com.wsl.entities.Comment;
import com.wsl.entities.Game;
import com.wsl.entities.Order;
import com.wsl.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CommentDao {

    @Autowired
    CommentMapper commentMapper;

    private static Map<Integer, Comment> comments = null;


    static{
        comments = new HashMap<Integer, Comment>();
        comments.put(1, new Comment(1,"刘希", "lol","有丶东西",new Date()));
        comments.put(2, new Comment(2,"刘希", "b","有丶东西",new Date()));
        comments.put(3, new Comment(3,"孙立飞", "c","有丶东西",new Date()));
        comments.put(4, new Comment(4,"王新宇", "a","有丶东西",new Date()));
    }

    private static Integer initId = 5;

    public void save(Comment comment){
        if(comment.getId() == null){
            comment.setId(initId++);
            commentMapper.insertComment(comment);
        }else commentMapper.updateComment(comment);
        comment.setDate(new Date());
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
        commentMapper.deleteCommentById(id);
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
