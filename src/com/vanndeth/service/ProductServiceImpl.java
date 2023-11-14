package com.vanndeth.service;

import com.vanndeth.dao.ProductDao;
import com.vanndeth.dao.ProductDaoImpl;
import com.vanndeth.database.ProductDatabase;
import com.vanndeth.exception.ProductCodeNotFoundException;
import com.vanndeth.model.Product;
import com.vanndeth.utils.Singleton;

import java.time.LocalDate;
import java.util.*;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final ProductDatabase productDatabase;
    private final Scanner scanner;
    public ProductServiceImpl() {
        productDao = Singleton.productDaoImpl();
        productDatabase = Singleton.productDatabase();
        scanner = Singleton.scanner();
    }
    @Override
    public Product insert(Product product) {
        product.setCode((long) (productDatabase.getProducts().size()+1));
        System.out.print("Enter name: ");
        product.setName(scanner.nextLine());
        System.out.print("Enter Price: ");
        product.setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.print("Enter Quantity: ");
        product.setQty(Integer.parseInt(scanner.nextLine()));
        product.setImportedDate(LocalDate.now());
        return productDao.insert(product);
    }

    @Override
    public List<Product> select() {
        return productDao.select();
    }

    @Override
    public Product selectByCode(Long code) {
        System.out.print("Enter product's code to search: ");
        code = Long.parseLong(scanner.nextLine());
        Long finalCode = code;
        return productDao.selectByCode(code)
                .orElseThrow(()
                        -> new ProductCodeNotFoundException(
                        String.format("Product code = %s does not exist in database!", finalCode)
                ));
    }

    @Override
    public Product updateByCode(Product product) {
        System.out.print("Enter product's code to update: ");
        product.setCode(Long.parseLong(scanner.nextLine()));
        return productDao.updateByCode(product);
    }

    @Override
    public Product deleteByCode(Long code) {
        System.out.print("Enter product's code to delete: ");
        code = Long.parseLong(scanner.nextLine());
        return productDao.deleteByCode(code);
    }

    @Override
    public List<Product> selectByName(String name) {
        System.out.print("Enter product's name to search: ");
        name = scanner.nextLine();
        return productDao.selectByName(name);
    }
}