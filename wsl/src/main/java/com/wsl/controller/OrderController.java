package com.wsl.controller;

import com.wsl.dao.GameDao;
import com.wsl.dao.OrderDao;
import com.wsl.dao.UserDao;
import com.wsl.entities.Department;
import com.wsl.entities.Game;
import com.wsl.entities.Order;
import com.wsl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class OrderController {
    @Autowired
    GameDao gameDao;

    @Autowired
    UserDao userDao;
    //查询所有员工返回列表页面
    @Autowired
    OrderDao orderDao;
    @GetMapping("/orders")
    public String getOrder(Model model,
                           HttpSession session){
        Collection<Order> orders=orderDao.getByU((String) session.getAttribute("loginUser"));
        model.addAttribute("orders",orders);
        return "order/orderList";
    }

    @GetMapping("/buy")
    public String toBuyPage(@RequestParam("id") Integer id,Model model,
                            @RequestParam("loginUser") String loginUser){
        Game game = gameDao.get(id);
        model.addAttribute("emp", game);
        User buyer=userDao.getByName(loginUser);
        model.addAttribute("buyer", buyer);
        //页面要显示所有的部门列表
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/buy";
    }

    @PostMapping("/order")
    public String buyGame(Order order){
        orderDao.save(order);
        return "redirect:/orders";
    }
}
