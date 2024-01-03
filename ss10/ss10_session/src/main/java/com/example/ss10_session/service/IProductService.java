package com.example.ss10_session.service;
import com.example.ss10_session.model.Product;
import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(long id);
}
