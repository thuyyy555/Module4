package com.example.service;

import com.example.model.Feedback;

import java.time.LocalDate;
import java.util.List;

public interface IFeedbackService {
    Feedback findByToday(LocalDate today);
    boolean create(Feedback feedback);
    boolean update(Feedback feedback);
    Feedback findById(int id);
    List<Feedback> findAll();
    boolean deleteById(int id);
}
