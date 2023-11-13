package com.vanndeth;

import com.vanndeth.controller.MenuController;
import com.vanndeth.controller.ProductController;
import com.vanndeth.service.ProductServiceImpl;
import com.vanndeth.utils.Singleton;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainApplication {
    private final Scanner scanner;
    private final MenuController menuController;
    private final ProductController productController;
    private final ProductServiceImpl productServiceImpl;
    public MainApplication(){
        scanner = Singleton.scanner();
        menuController = Singleton.menuController();
        productController = Singleton.productController();
        productServiceImpl = Singleton.productServiceImpl();
    }

    private void run() {
        menuController.index();
        System.out.print("Please choose options : ");
        int option = Integer.parseInt(scanner.nextLine());

        // initialize manual
//        ProductController productController = new ProductController();
//        productController.index();

        switch (option) {
            case 1 -> productController.index();
            default -> throw new IllegalStateException();
        }
    }

    public static void main(String[] args) {

        new MainApplication().run();
    }
}
