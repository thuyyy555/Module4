package com.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @PostMapping("/save")
    public String findWord(@RequestParam(value = "val1", required = false) String val1,@RequestParam(value = "val2", required = false) String val2,
                           @RequestParam(value = "val3", required = false) String val3,@RequestParam(value = "val4", required = false) String val4, Model model) {
        List list = new ArrayList<>();
        list.add(val1);
        list.add(val2);
        list.add(val3);
        list.add(val4);
        model.addAttribute("list", list);
        return "index";
    }
    @GetMapping(value = "/save")
    public String showForm(Model model){
        return"index";
    }
}