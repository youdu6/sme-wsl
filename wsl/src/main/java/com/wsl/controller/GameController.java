package com.wsl.controller;

import com.wsl.dao.GameDao;
import com.wsl.dao.UserDao;
import com.wsl.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

@Controller
public class GameController {
    @Autowired
    GameDao gameDao;

    @Autowired
    UserDao userDao;
    @GetMapping("/emps")
    public String  list(Model model){
        Collection<Game> games = gameDao.getAll();

        //放在请求域中
        model.addAttribute("emps", games);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model,
                            HttpSession session){
        //来到添加页面,查出所有的部门，在页面显示
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Game game){
        //来到员工列表页面
        //保存员工
        gameDao.save(game);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Game game = gameDao.get(id);
        model.addAttribute("emp", game);

        //页面要显示所有的部门列表
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Game game){
        System.out.println("修改的游戏数据："+ game);
        gameDao.save(game);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        gameDao.delete(id);
        return "redirect:/emps";
    }

    @GetMapping("/signout")
    public String signout(HttpSession session){
        session=null;
        return "redirect:/";
    }

    @PostMapping(value = "/search")
    public String search(Model model,
                         @RequestParam("search") String search){

        Collection<Game> games = gameDao.getAll();
        ArrayList<Game> results = new ArrayList<>();
        search=".*"+search+".*";
        for (Game game:games){
            if (Pattern.matches(search, game.getName())){
                results.add(game);
            }
        }
        model.addAttribute("emps",results);
//        model.addAttribute("emps",games);
//        return "redirect:/emp/searchResult";
        return "emp/searchResult";
    }

    @GetMapping("/search")
    public String  searchlist(){
        return "emp/searchResult";
    }
}
