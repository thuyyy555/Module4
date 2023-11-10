package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    void create(Product product);

    void delete(Product product);

    void update(String id, Product product);

    Product findById(String id);

    List<Product> findAll();

}
