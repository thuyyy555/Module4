package com.example.ss7_1.service.impl;

import com.example.ss7_1.model.Blog;
import com.example.ss7_1.repository.BlogRepository;
import com.example.ss7_1.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository repository;
    @Override
    public boolean create(Blog blog) {
        repository.save(blog);
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        repository.save(blog);
        return true;
    }

    @Override
    public Blog findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Blog> findAllByTitle(String name) {
        return repository.findAllByTitleContaining(name);
    }

    @Override
    public Page<Blog> findAllAndPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Slice<Blog> findAllSlice(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Blog> findAllByCategory_CategoryId(int id) {
        return repository.findAllByCategory_CategoryId(id);
    }
}
