package com.vanndeth.controller;

import com.vanndeth.database.ProductDatabase;
import com.vanndeth.model.Product;
import com.vanndeth.service.ProductService;
import com.vanndeth.service.ProductServiceImpl;
import com.vanndeth.utils.Singleton;
import com.vanndeth.view.ProductView;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    private final ProductService productService;
    public ProductController() {

        productService = Singleton.productServiceImpl();
    }
    public void getAllProduct() {
        List<Product> products = productService.select();
        ProductView.printProductList(products);
    }

    public void createProduct(Product product){
        productService.insert(product);
    }


    public void updateProductByCode(Product product){
        productService.updateByCode(product);
    }

    public void deleteProductByCode(Long code){
        productService.deleteByCode(code);
    }
    public void  getProductByCode(Long code){
        productService.selectByCode(code);
    }

    public void getProductByName(String name){
        productService.selectByName(name);
    }

}
