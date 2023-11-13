package com.vanndeth.service;

import com.vanndeth.model.Product;

import java.util.List;

public interface ProductService {
    Product insert(Product product);

    List<Product> select();

    Product selectByCode(Long code);
    Product updateByCode(Product product);
    Product deleteByCode(Long code);

    List<Product> selectByName(String name);

}
