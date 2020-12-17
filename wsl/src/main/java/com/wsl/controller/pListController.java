package com.wsl.controller;

import com.wsl.dao.GameDao;
import com.wsl.dao.OrderDao;
import com.wsl.dao.ProducerDao;
import com.wsl.dao.UserDao;
import com.wsl.entities.Game;
import com.wsl.entities.Order;
import com.wsl.entities.Producer;
import com.wsl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class pListController {
    @Autowired
    GameDao gameDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ProducerDao producerDao;
    //查询所有员工返回列表页面
    @Autowired
    OrderDao orderDao;
    @GetMapping("/pLists")
    public String getOrder(Model model,
                           HttpSession session){
        if (session.getAttribute("isAdmin").equals(true)){
            Collection<Game> games=gameDao.getAll();
            model.addAttribute("games",games);
            return "emp/pList";
        }
        Collection<Game> games=gameDao.getBypName((String) session.getAttribute("loginUser"));
        model.addAttribute("games",games);
        return "emp/pList";
    }
}
