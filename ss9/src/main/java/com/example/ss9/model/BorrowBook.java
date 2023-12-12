package com.example.ss9.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowBook {
    @Id
    int borrowId;
    @ManyToOne
    @JoinColumn(name = "id")
    private Book book;

    public BorrowBook() {
    }

    public BorrowBook(int borrowId, Book book) {
        this.borrowId = borrowId;
        this.book = book;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
