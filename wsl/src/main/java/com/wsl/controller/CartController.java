package com.wsl.controller;

import com.wsl.dao.*;
import com.wsl.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class CartController {
    @Autowired
    GameDao gameDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ProducerDao producerDao;
    //查询所有员工返回列表页面
    @Autowired
    OrderDao orderDao;
    @Autowired
    CartDao cartDao;
    @GetMapping("/carts")
    public String getOrder(Model model,
                           HttpSession session){
        Cart cart=cartDao.getByuName((String) session.getAttribute("loginUser"));
        ArrayList<Game> games=cartDao.getGames((String) session.getAttribute("loginUser"));
        model.addAttribute("cart",cart);
        model.addAttribute("games",games);
        return "cart";
    }

    @GetMapping("/cart")
    public String toCartPage(@RequestParam("id") Integer id,Model model,
                            @RequestParam("loginUser") String loginUser){
        Cart cart=cartDao.getByuName(loginUser);
        cart.getGames().add(gameDao.get(id));
        return "redirect:/carts";
    }

    @GetMapping("/deleteCart")
    public String DeleteCart(@RequestParam("id") Integer id,Model model,
                             @RequestParam("loginUser") String loginUser){
        Cart cart=cartDao.getByuName(loginUser);
        cart.getGames().remove(gameDao.get(id));
        return "redirect:/carts";
    }
}
