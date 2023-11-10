package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<String, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put("P001", new Product("P001", "SP01", 10.0, "none", "NSX01"));
        productMap.put("P002", new Product("P002", "SP02", 10.0, "none", "NSX02"));
        productMap.put("P003", new Product("P003", "SP03", 10.0, "none", "NSX03"));
        productMap.put("P004", new Product("P004", "SP04", 10.0, "none", "NSX04"));
        productMap.put("P005", new Product("P005", "SP05", 10.0, "none", "NSX05"));
    }

    @Override
    public void create(Product product) {
        if (!productMap.containsKey(product.getId())) {
            productMap.put(product.getId(), product);
        }
    }

    @Override
    public void delete(Product product) {
        productMap.remove(product.getId());
    }

    @Override
    public void update(String id, Product product) {
        if (productMap.containsKey(product.getId())) {
            productMap.put(id, product);
        }
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

}
