package com.order.controller;

import com.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value={"/", "index"}, method= RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("/user/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

}
