package com.vanndeth.controller;

import com.vanndeth.model.Product;
import com.vanndeth.service.ProductService;
import com.vanndeth.service.ProductServiceImpl;
import com.vanndeth.view.ProductView;

import java.util.List;
public class ProductController {
    private final ProductService productService;
    public ProductController() {
        productService = new ProductServiceImpl();
    }
    public void index() {
        List<Product> products = productService.select();
        ProductView.printProductList(products);
    }

}
