package com.waylau.spring.boot.blog.initializrstart.Contoller;

import com.waylau.spring.boot.blog.initializrstart.domain.User;
import com.waylau.spring.boot.blog.initializrstart.resp.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * 从 用户存储库 获取用户列表
     * @return
     */
    public List<User> getuserlist(){
        return userRepository.listUser();
    }

    @GetMapping
    public ModelAndView userlist(Model model){
        model.addAttribute("userList",getuserlist());
        model.addAttribute("title","用户管理系统");
        return  new ModelAndView("users/list","userModel",model);
    }

    //获取form
    @GetMapping("/form")
    public ModelAndView getform(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    //创建新用户
    @PostMapping
    public ModelAndView createuser(User user){
        user=userRepository.saveupdateuser(user)    ;
        return new ModelAndView("redirect:/users");
    }






}
