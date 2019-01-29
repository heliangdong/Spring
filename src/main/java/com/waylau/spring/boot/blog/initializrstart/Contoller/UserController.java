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
        List<User> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            users.add(user);
        }
        return users;
    }

    @GetMapping
    public ModelAndView userlist(Model model){
        model.addAttribute("userList",getuserlist());
        model.addAttribute("title","用户管理系统");
        return  new ModelAndView("users/list","userModel",model);
    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User(null, null));
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    @PostMapping
    public ModelAndView createuser(User user){
        userRepository.save(user);
        return new ModelAndView("redirect:users");
    }

    //根据用户ID，获取用户信息

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    //删除用户
    @GetMapping("delete/{id}")
    public ModelAndView deleteuser(@PathVariable("id") Long id, Model model){
        userRepository.delete(id);
        model.addAttribute("userList", getuserlist());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    @GetMapping("modify/{id}")
    public ModelAndView updateuser(@PathVariable("id") Long id, Model model){
        User user=userRepository.findOne(id);
        model.addAttribute("user",user);
        model.addAttribute("title","修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }






}
