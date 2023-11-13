package com.vanndeth.dao;

import com.vanndeth.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Product insert(Product product);

    List<Product> select();

    Optional<Product> selectByCode(Long code);
    Product updateByCode(Product product);
    Product deleteByCode(Long code);

    List<Product> selectByName(String name);
}
