package com.example.controller;

import com.example.model.Feedback;
import com.example.model.Picture;
import com.example.repository.IFeedbackRepository;
import com.example.repository.IPictureRepository;
import com.example.repository.PictureRepository;
import com.example.service.IFeedbackService;
import com.example.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import scala.concurrent.impl.FutureConvertersImpl;


import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/picture")
public class PictureController {
//    @Autowired
//    private IPictureRepository pictureRepository;
//    @Autowired
//    private IFeedbackRepository feedbackRepository;
    @Autowired
    private IPictureService pictureService;
    @Autowired
    private IFeedbackService feedbackService;
    @GetMapping("/show")
    public String showCreate(Model model) {
        List<Picture> pictures = pictureService.findAll();
        Picture picture;
        if (!pictures.isEmpty()) {
            picture = pictures.get(pictures.size()-1);
            if (!picture.getToday().equals(LocalDate.now())) {
                picture = new Picture(pictures.size()+1, LocalDate.now());
                System.out.println("a");
                System.out.println(picture.getIdPicture());
            }
        } else {
            picture = new Picture(LocalDate.now());
            System.out.println("b");
            System.out.println(picture.getIdPicture());
        }
        model.addAttribute("picture", picture);
        model.addAttribute("feedbacks", feedbackService.findAll());
        model.addAttribute("feedback", new Feedback());
        return "index";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("feedback") Feedback feedback) {
        feedback.setToday(LocalDate.now());
        feedbackService.create(feedback);
        return "redirect:/picture/show";
    }
    @PostMapping("/like")
    public String likePicture(@RequestParam("feedbackId") int feedbackId) {
        Feedback feedback = feedbackService.findById(feedbackId);
        if (feedback != null) {
            feedback.setCount(feedback.getCount() + 1);
            feedbackService.update(feedback);
        }
        return "redirect:/picture/show";
    }
}
