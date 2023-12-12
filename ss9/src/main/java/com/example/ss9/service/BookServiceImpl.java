package com.example.ss9.service;

import com.example.ss9.model.Book;
import com.example.ss9.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> findAllByTitle(String name) {
        return bookRepository.findAllByTitleContaining(name);
    }

    @Override
    public boolean create(Book book) {
        bookRepository.save(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        bookRepository.save(book);
        return true;
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        bookRepository.deleteById(id);
        return true;
    }
}
