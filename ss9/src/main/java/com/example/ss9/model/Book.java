package com.example.ss9.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<BorrowBook> books;

    public Book() {
    }

    public Book(int id, String title, int quantity, List<BorrowBook> books) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BorrowBook> getBooks() {
        return books;
    }

    public void setBooks(List<BorrowBook> books) {
        this.books = books;
    }
}
