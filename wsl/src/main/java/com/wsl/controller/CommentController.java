package com.wsl.controller;

import com.wsl.dao.*;
import com.wsl.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class CommentController {
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
    CommentDao commentDao;
    @GetMapping("/comments")
    public String getOrder(Model model,
                           HttpSession session){
        Collection<Comment> comments=commentDao.getAll();
        model.addAttribute("comments",comments);
        return "comment";
    }
    @GetMapping("/comment")
    public String toBuyPage(@RequestParam("gid") String gid,Model model,
                            @RequestParam("loginUser") String loginUser){
        model.addAttribute("game",gameDao.findById(Integer.parseInt(gid)));
        model.addAttribute("user",userDao.getByName(loginUser));
        //页面要显示所有的部门列表
        //回到修改页面(add是一个修改添加二合一的页面);
        return "commenting";
    }
    @PostMapping("commenting")
    public String addComment(Comment comment){
        commentDao.save(comment);
        return "redirect:/comments";
    }
}
