package com.example.repository;

import com.example.model.Blog;

import java.util.List;

public interface IBlogRepository {
    boolean create(Blog blog);
    boolean update(Blog blog);
    Blog findById(int id);
    List<Blog> findAll();
    boolean deleteById(int id);
}
