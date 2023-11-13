package com.vanndeth.dao;

import com.vanndeth.database.ProductDatabase;
import com.vanndeth.exception.ProductCodeNotFoundException;
import com.vanndeth.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao{
    private  final ProductDatabase productDb;

    public ProductDaoImpl() {
        productDb = new ProductDatabase();
    }
    @Override
    public Product insert(Product product) {
        productDb.getProducts().add(product);
        return product;
    }

    @Override
    public List<Product> select() {
        return productDb.getProducts();
    }

    @Override
    public Optional<Product> selectByCode(Long code) {
        return productDb.getProducts().stream()
                .filter(product -> product.getCode().equals(code))
                .findFirst();
    }

    @Override
    public Product updateByCode(Product product) {
        return productDb.getProducts().stream()
                .filter(pro -> pro.getCode().equals(product.getCode()))
                .map(newPro -> product)
                .findFirst()
                .orElseThrow(() -> new ProductCodeNotFoundException(
                        String.format("Product ID = %s does not exist in DB!",product.getCode())
                ));
    }

    @Override
    public Product deleteByCode(Long code) {
        Product foundProduct = productDb.getProducts().stream()
                .filter(pro -> pro.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new ProductCodeNotFoundException(
                        String.format("Product ID = %s does not exist in DB!", code)
                ));
        productDb.getProducts().remove(foundProduct);
        return foundProduct;

    }

    @Override
    public List<Product> selectByName(String name) {
        return productDb.getProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
