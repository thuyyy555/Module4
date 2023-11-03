package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping()
public class Controller {
    @PostMapping("/vnd")
    public String greeting(@RequestParam int gia,  int usd, Model model) {
        int result = usd * gia;
        model.addAttribute("result", result);
        return "index";
    }
    @GetMapping(value = "/vnd")
    public String showForm(Model model){
        return"index";
    }
}