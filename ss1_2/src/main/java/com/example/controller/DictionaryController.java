package com.example.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
@org.springframework.stereotype.Controller
public class DictionaryController {
    String[] array1 = {"dog", "cat", "rabbit"};
    String[] array2 = {"chó", "mèo", "thỏ"};
    @PostMapping("/change")
    public String findWord(@RequestParam String word, Model model) {
        String result="";
        if(find(word)){
            result=getWord(word);
        }
        model.addAttribute("result", result);
        return "index";
    }
    @GetMapping(value = "/change")
    public String showForm(Model model){
        return"index";
    }
    boolean find(String input){
        boolean found = false;
        for (int i = 0; i < array1.length; i++) {
            if (input.equals(array1[i])) {
                found = true;
                break;
            }
        }
        return found;
    }
    String getWord(String input){
        String res="";
        for (int i = 0; i < array1.length; i++) {
            if (input.equals(array1[i])) {
                int result = Arrays.asList(array1).indexOf(array1[i]);
                res=array2[result];
                break;
            }
        }
        return res;
    }
}