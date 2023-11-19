package com.example.controller;

import com.example.model.Feedback;
import com.example.model.Picture;
import com.example.repository.IFeedbackRepository;
import com.example.repository.IPictureRepository;
import com.example.repository.PictureRepository;
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
    @Autowired
    private IPictureRepository pictureRepository;
    @Autowired
    private IFeedbackRepository feedbackRepository;
    @GetMapping("/show")
    public String showCreate(Model model) {
        List<Picture> pictures = pictureRepository.findAll();
        Picture picture;
        if (!pictures.isEmpty()) {
            picture = pictures.get(pictures.size()-1);
            if (!picture.getToday().equals(LocalDate.now())) {
                picture = new Picture(LocalDate.now());
            }
        } else {
            picture = new Picture(LocalDate.now());
        }
        model.addAttribute("picture", picture);
        model.addAttribute("feedbacks", feedbackRepository.findAll());
        model.addAttribute("feedback", new Feedback());
        return "index";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("feedback") Feedback feedback) {
        List<Picture> pictures = pictureRepository.findAll();
        Picture picture;
        if (!pictures.isEmpty()) {
            picture = pictures.get(pictures.size()-1);
        }else {
            picture = new Picture();
        }
        picture.setToday(LocalDate.now());
        pictureRepository.update(picture);
        feedback.setToday(LocalDate.now());
        feedbackRepository.create(feedback);
        return "redirect:/picture/show";
    }
    @PostMapping("/like")
    public String likePicture(@RequestParam("feedbackId") int feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId);
        if (feedback != null) {
            feedback.setCount(feedback.getCount() + 1);
            feedbackRepository.update(feedback);
        }
        return "redirect:/picture/show";
    }
}
