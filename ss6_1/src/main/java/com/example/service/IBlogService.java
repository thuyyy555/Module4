package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {
    boolean create(Blog blog);
    boolean update(Blog blog);
    Blog findById(int id);
    List<Blog> findAll();
    boolean deleteById(int id);
}
