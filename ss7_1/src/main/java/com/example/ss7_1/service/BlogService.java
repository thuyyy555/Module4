package com.example.ss7_1.service;

import com.example.ss7_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface BlogService extends Service<Blog> {
    List<Blog> findAllByTitle(String name);
    Page<Blog> findAllAndPaging(Pageable pageable);
    Slice<Blog> findAllSlice(Pageable pageable);
    List<Blog> findAllByCategory_CategoryId(int id);
}
