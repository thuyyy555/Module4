package com.example.ss8.controller;

import com.example.ss8.model.User;
import com.example.ss8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/list")
    public String showFormCreate(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping("/create")
    public String doCreate(@Validated @ModelAttribute("user") User user,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        userService.create(user);
        return "result";
    }
}
