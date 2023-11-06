package com.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@org.springframework.stereotype.Controller
public class CalculatorController {
    @PostMapping("/calculate")
    public String calculate(@RequestParam("num1") int num1, @RequestParam("num2") int num2, @RequestParam("operation") String operation, Model model) {
        int result = 0;
        String badRes = "Không thể chia cho 0";

        switch (operation) {
            case "Addition":
                result = num1 + num2;
                model.addAttribute("result", result);
                break;
            case "Subtraction":
                result = num1 - num2;
                model.addAttribute("result", result);
                break;
            case "Multiplication":
                result = num1 * num2;
                model.addAttribute("result", result);
                break;
            case "Division":
                if (num2 == 0) {
                    model.addAttribute("badRes", badRes);
                    break;
                } else {
                    result = num1 / num2;
                    model.addAttribute("result", result);
                    break;
                }
        }
        return "index";
    }

    @GetMapping(value = "/calculate")
    public String showForm(Model model) {
        return "index";
    }
}