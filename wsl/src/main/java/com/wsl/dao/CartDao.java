package com.wsl.dao;

import com.wsl.entities.Cart;
import com.wsl.entities.Game;
import com.wsl.entities.Order;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.*;

@Repository
public class CartDao {

    private static Map<Integer, Cart> carts = null;


    static{
        carts = new HashMap<Integer, Cart>();
        carts.put(1, new Cart(1,new ArrayList<Game>(),"刘希"));
        carts.put(2, new Cart(2,new ArrayList<Game>(),"孙立飞"));
        carts.put(3, new Cart(3,new ArrayList<Game>(),"王新宇"));
    }

    private static Integer initId = 4;

    public void save(Cart cart){
        if(cart.getId() == null){
            cart.setId(initId++);
        }

        carts.put(cart.getId(), cart);
    }

    //查询所有员工
    public Collection<Cart> getAll(){
        return carts.values();
    }

    public Cart get(Integer id){
        return carts.get(id);
    }

    public Cart getByuName(String uName){
        for (Cart cart:this.getAll()){
            if (cart.getuName().equals(uName)){
                return cart;
            }
        }
        return null;
    }

    public void delete(Integer id){
        carts.remove(id);
    }

    public ArrayList<Game> getGames(String uName){
        for (Cart cart:this.getAll()){
            if (cart.getuName().equals(uName)){
                return cart.getGames();
            }
        }
        return null;
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
