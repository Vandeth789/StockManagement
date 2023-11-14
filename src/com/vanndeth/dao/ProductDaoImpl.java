package com.vanndeth.dao;

import com.vanndeth.database.ProductDatabase;
import com.vanndeth.exception.ProductCodeNotFoundException;
import com.vanndeth.model.Product;
import com.vanndeth.utils.Singleton;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductDaoImpl implements ProductDao{
    private  final ProductDatabase productDatabase;
    private final Scanner scanner;
    public ProductDaoImpl() {
        productDatabase = Singleton.productDatabase();
        scanner = Singleton.scanner();
    }
    @Override
    public Product insert(Product product) {
        productDatabase.getProducts().add(product);
        return product;
    }

    @Override
    public List<Product> select() {

        return productDatabase.getProducts();
    }

    @Override
    public Optional<Product> selectByCode(Long code) {
        return productDatabase.getProducts().stream()
                .filter(product -> product.getCode().equals(code))
                .findFirst();
    }

    @Override
    public Product updateByCode(Product product) {
        System.out.print("Enter new product's name: ");
        product.setName(scanner.nextLine());
        System.out.print("Enter new product's price: ");
        product.setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.print("Enter new product's quantity: ");
        product.setQty(Integer.parseInt(scanner.nextLine()));
        product.setImportedDate(LocalDate.now());

        Product foundProduct = productDatabase.getProducts().stream()
            .filter(pro -> pro.getCode().equals(product.getCode()))
            .findFirst()
            .orElseThrow(() -> new ProductCodeNotFoundException(
                    String.format("Product's code = %s does not exist in database!",product.getCode())
                    )
            );
        int index = Math.toIntExact(foundProduct.getCode());
        return productDatabase.getProducts().set(index-1, product);
    }

    @Override
    public Product deleteByCode(Long code) {
        Product foundProduct = productDatabase.getProducts().stream()
                .filter(pro -> pro.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new ProductCodeNotFoundException(
                        String.format("Product code = %s does not exist in database!", code)
                ));
        productDatabase.getProducts().remove(foundProduct);
        System.out.println(String.format("Product's code %s was deleted...!", code));
        return foundProduct;
    }
    @Override
    public List<Product> selectByName(String name) {
        return productDatabase.getProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
