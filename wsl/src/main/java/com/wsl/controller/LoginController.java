package com.wsl.controller;

import com.wsl.dao.ProducerDao;
import com.wsl.dao.UserDao;
import com.wsl.entities.Game;
import com.wsl.entities.Producer;
import com.wsl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping
    @Autowired
    UserDao userDao;
    @Autowired
    ProducerDao producerDao;
    //@RequestMapping(value = "/User/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session){
        Collection<User>  users=userDao.getAll();
        for (User user:users){
            if (user.getName().equals(username)){
                if (user.getPassword()==Integer.parseInt(password)) {
                    session.setAttribute("loginUser", username);
                    session.setAttribute("isUser",true);
                    return "redirect:/main.html";
                }else break;
            }
        }


        Collection<Producer>  producers=producerDao.getAll();
        for (Producer producer:producers){
            if (producer.getName().equals(username)){
                if (producer.getPassword()==Integer.parseInt(password)) {
                    session.setAttribute("loginUser", username);
                    session.setAttribute("isUser",false);
                    return "redirect:/main.html";
                }else break;
            }
        }

//        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
//
//            session.setAttribute("loginUser",username);
//            return "redirect:/main.html";
////            return "dashboard2";
//        }else{

//        }
        map.put("msg","username/password wrong!");
        return  "login";
    }

    @GetMapping(value = "/user/register")
    public String register(){
        return "register";
    }

    @PostMapping(value = "/user/register")
    public String registerSolve(@RequestParam("username") String username,
                                @RequestParam("password") String password){
        Collection<User> users=userDao.getAll();
        userDao.save(new User(null,username,Integer.parseInt(password)));
        return "redirect:/";
    }
}
