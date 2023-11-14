package com.vanndeth.view;

import com.vanndeth.model.Product;

import java.util.List;

public class ProductView {
    public static void printProductList(List<Product> products) {
        System.out.println("======= Product List =======");
        products.forEach(product -> {
            System.out.println("CODE : " + product.getCode());
            System.out.println("NAME : " + product.getName());
            System.out.println("QTY : " + product.getQty());
            System.out.println("PRICE : " + product.getPrice());
            System.out.println("IMPORTED DATE : " + product.getImportedDate());
        });
    }

    public static void displayProduct(Product product) {
        System.out.println("======= Product List =======");
        System.out.println("CODE : " + product.getCode());
        System.out.println("NAME : " + product.getName());
        System.out.println("QTY : " + product.getQty());
        System.out.println("PRICE : " + product.getPrice());
        System.out.println("IMPORTED DATE : " + product.getImportedDate());
    }
}
