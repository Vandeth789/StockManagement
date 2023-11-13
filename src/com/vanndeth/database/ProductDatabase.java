package com.vanndeth.database;

import com.vanndeth.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private List<Product> products;
    public List<Product> getProducts() {
        return products;
    }
    public ProductDatabase() {
        products = new ArrayList<>();
        products.add(new Product(1L,"Coca",2500.0,100, LocalDate.now()));
        products.add(new Product(2L,"Virgo",3000.0,150, LocalDate.now()));
        products.add(new Product(3L,"Pepsi",2000.0,80, LocalDate.now()));
        products.add(new Product(4L,"Fanta",2000.0,200, LocalDate.now()));
        products.add(new Product(5L,"Sting",2500.0,50, LocalDate.now()));
    }

}
