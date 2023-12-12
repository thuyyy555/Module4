package com.example.ss9.service;

import com.example.ss9.model.Book;
import com.example.ss9.model.BorrowBook;
import com.example.ss9.repository.BorrowBRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowBServiceImpl implements BorrowBService {
    @Autowired
    BorrowBRepository borrowBRepository;

    @Override
    public boolean create(BorrowBook borrowBook) {
        borrowBRepository.save(borrowBook);
        return true;
    }

    @Override
    public boolean update(BorrowBook borrowBook) {
        borrowBRepository.save(borrowBook);
        return true;
    }

    //    @Override
//    public BorrowBook findById(int id) {
//        return borrowBRepository.findById(id).orElse(null);
//    }
    @Override
    public BorrowBook findById(int id) {
        return borrowBRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BorrowBook with id " + id + " not found"));
    }


    @Override
    public List<BorrowBook> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
