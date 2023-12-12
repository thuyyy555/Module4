package com.example.ss9.repository;

import com.example.ss9.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    List<Book> getAllBooks();
//
//    Book borrowBook(int bookId);
//
//    boolean returnBook(int bookId, int borrowedCode);
    public List<Book> findAllByTitleContaining(String name);

}
