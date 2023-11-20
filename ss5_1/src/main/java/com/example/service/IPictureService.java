package com.example.service;

import com.example.model.Picture;

import java.time.LocalDate;
import java.util.List;

public interface IPictureService {
    Picture findByToday(LocalDate today);
    boolean create(Picture picture);
    boolean update(Picture picture);
    Picture findById(int id);
    List<Picture> findAll();
    boolean deleteById(int id);
}
