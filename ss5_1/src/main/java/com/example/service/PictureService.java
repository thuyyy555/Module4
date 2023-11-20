package com.example.service;

import com.example.model.Picture;
import com.example.repository.IPictureRepository;
import com.example.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PictureService implements IPictureService{
    @Autowired
    private IPictureRepository pictureRepository;
    @Override
    public Picture findByToday(LocalDate today) {
        return pictureRepository.findByToday(today);
    }

    @Override
    public boolean create(Picture picture) {
        return pictureRepository.create(picture);
    }

    @Override
    public boolean update(Picture picture) {
        return pictureRepository.update(picture);
    }

    @Override
    public Picture findById(int id) {
        return pictureRepository.findById(id);
    }

    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        return pictureRepository.deleteById(id);
    }
}
