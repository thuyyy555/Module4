package com.example.ss7_1.service;


import com.example.ss7_1.model.Blog;
import com.example.ss7_1.model.Category;

import java.util.List;

public interface CategoryService extends Service<Category> {
    List<Category> findAllByCategoryName(String name);
}
