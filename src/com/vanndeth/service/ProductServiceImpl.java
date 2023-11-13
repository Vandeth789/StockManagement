package com.vanndeth.service;

import com.vanndeth.dao.ProductDao;
import com.vanndeth.dao.ProductDaoImpl;
import com.vanndeth.exception.ProductCodeNotFoundException;
import com.vanndeth.model.Product;
import com.vanndeth.utils.Singleton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    public ProductServiceImpl() {
//        productDao = new ProductDaoImpl();
        productDao = Singleton.productDaoImpl();
    }
    @Override
    public Product insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public List<Product> select() {
        return productDao.select();
    }

    @Override
    public Product selectByCode(Long code) {
        return productDao.selectByCode(code)
                .orElseThrow(()
                        -> new ProductCodeNotFoundException(
                        String.format("Product code = %d does not exist in DB!", code)
                ));
    }

    @Override
    public Product updateByCode(Product product) {
        return productDao.updateByCode(product);
    }

    @Override
    public Product deleteByCode(Long code) {
        return productDao.deleteByCode(code);
    }

    @Override
    public List<Product> selectByName(String name) {
        return productDao.selectByName(name);
    }
}