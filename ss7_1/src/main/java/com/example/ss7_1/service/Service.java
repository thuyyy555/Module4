package com.example.ss7_1.service;

import java.util.List;

public interface Service<T> {
    boolean create(T t);
    boolean update(T t);
    T findById(int id);
    List<T> findAll();
    boolean deleteById(int id);
}
