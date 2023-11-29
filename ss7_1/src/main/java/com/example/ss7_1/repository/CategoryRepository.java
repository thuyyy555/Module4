package com.example.ss7_1.repository;

import com.example.ss7_1.model.Blog;
import com.example.ss7_1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findAllByCategoryNameContaining(String name);
}
