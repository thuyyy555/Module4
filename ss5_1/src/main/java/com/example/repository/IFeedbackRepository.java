package com.example.repository;

import com.example.model.Feedback;
import com.example.model.Picture;

import java.time.LocalDate;
import java.util.List;

public interface IFeedbackRepository {
    Feedback findByToday(LocalDate today);
    boolean create(Feedback feedback);
    boolean update(Feedback feedback);
    Feedback findById(int id);
    List<Feedback> findAll();
    boolean deleteById(int id);
}
