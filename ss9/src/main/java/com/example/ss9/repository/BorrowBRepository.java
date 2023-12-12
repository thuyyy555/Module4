package com.example.ss9.repository;

import com.example.ss9.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBRepository extends JpaRepository<BorrowBook, Integer> {

}
