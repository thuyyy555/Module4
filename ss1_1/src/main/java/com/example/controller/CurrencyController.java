package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
@RequestMapping()
public class CurrencyController {
    @PostMapping("/convert")
    public String convert(@RequestParam int exchangeRate,  @RequestParam int usd, Model model) {
        int result = usd * exchangeRate;
        model.addAttribute("result", result);
        return "index";
    }
    @GetMapping(value = "/convert")
    public String showForm(Model model){
        return"index";
    }
}