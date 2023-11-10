package com.example.controller;
import com.example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    @GetMapping("/update")
    public ModelAndView showForm(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("email", new Email());
        modelAndView.addObject("languageArray", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSizeArray", new String[]{"5", "10","15", "25", "50", "100"});
        return modelAndView;
    }

    @PostMapping("/update")
    public String submit(@ModelAttribute("email") Email email, ModelMap model) {
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("pageSize", email.getPageSize());
        model.addAttribute("filter", email.getFilter());
        model.addAttribute("signature", email.getSignature());
        return "list";
    }
}