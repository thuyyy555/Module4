package com.example.ss7_1.service.impl;

import com.example.ss7_1.model.Blog;
import com.example.ss7_1.model.Category;
import com.example.ss7_1.repository.CategoryRepository;
import com.example.ss7_1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public boolean create(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public boolean update(Category category) {
        categoryRepository.save(category);
        return true;
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Category> findAllByCategoryName(String name) {
        return categoryRepository.findAllByCategoryNameContaining(name);
    }
}
