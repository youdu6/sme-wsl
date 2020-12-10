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
public class NoticeController {
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
    NoticeDao noticeDao;
    @GetMapping("/notices")
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

    @DeleteMapping("/notice/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        noticeDao.delete(id);
        return "redirect:/main.html";
    }
    @GetMapping("/notice")
    public String toNoticeAddPage(Model model,
                            HttpSession session){
        //来到添加页面,查出所有的部门，在页面显示
        return "notice/addNotice";
    }
    @PostMapping("/notice")
    public String addEmp(Notice notice){
        //来到员工列表页面
        //保存员工
        noticeDao.save(notice);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/main.html";
    }
}
