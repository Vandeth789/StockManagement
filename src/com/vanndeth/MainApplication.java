package com.vanndeth;

import com.vanndeth.controller.MenuController;
import com.vanndeth.controller.ProductController;
import com.vanndeth.database.ProductDatabase;
import com.vanndeth.model.Product;
import com.vanndeth.service.ProductServiceImpl;
import com.vanndeth.utils.Singleton;

import java.util.Scanner;

public class MainApplication {
    private final Scanner scanner;
    private final MenuController menuController;
    private final ProductController productController;
    private final ProductServiceImpl productServiceImpl;
    private final ProductDatabase productDatabase;
    public MainApplication(){
        scanner = Singleton.scanner();
        menuController = Singleton.menuController();
        productController = Singleton.productController();
        productServiceImpl = Singleton.productServiceImpl();
        productDatabase = Singleton.productDatabase();
    }

    private void run() {
        do {
            Product product = new Product();
            menuController.displayProductList();
            System.out.print("Please choose options : ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> {
                    productController.getAllProduct();
                }
                case 2 -> {
                    productController.createProduct(product);

                }
                case 3 -> {
                    productController.updateProductByCode(product);
                }
                case 4 -> {
                    productController.deleteProductByCode(product.getCode());

                }
                case 5 -> {
                    productController.getProductByCode(product.getCode());

                }
                case 6 -> {

                    productController.getProductByName(product.getName());

                }

                default -> throw new IllegalStateException();
            }
        }while (true);
    }
    public static void main(String[] args) {
        new MainApplication().run();
    }
}
