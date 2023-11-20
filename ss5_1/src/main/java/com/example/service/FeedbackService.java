package com.example.service;

import com.example.model.Feedback;
import com.example.repository.FeedbackRepository;
import com.example.repository.IFeedbackRepository;
import com.example.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class FeedbackService implements IFeedbackService{
    @Autowired
    private IFeedbackRepository feedbackRepository;

    @Override
    public Feedback findByToday(LocalDate today) {
        return feedbackRepository.findByToday(today);
    }

    @Override
    public boolean create(Feedback feedback) {
        return feedbackRepository.create(feedback);
    }

    @Override
    public boolean update(Feedback feedback) {
        return feedbackRepository.update(feedback);
    }

    @Override
    public Feedback findById(int id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return feedbackRepository.deleteById(id);
    }
}
