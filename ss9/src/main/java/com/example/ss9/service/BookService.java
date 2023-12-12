package com.example.ss9.service;

import com.example.ss9.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface BookService extends Service<Book> {
    List<Book> findAllByTitle(String name);
}
