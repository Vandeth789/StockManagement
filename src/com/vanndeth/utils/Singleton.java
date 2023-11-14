package com.vanndeth.utils;

import com.vanndeth.controller.MenuController;
import com.vanndeth.controller.ProductController;
import com.vanndeth.dao.ProductDaoImpl;
import com.vanndeth.database.ProductDatabase;
import com.vanndeth.service.ProductService;
import com.vanndeth.service.ProductServiceImpl;
import com.vanndeth.view.MenuView;

import java.util.Scanner;

public class Singleton {
    private static Scanner scanner;
    private static MenuController menuController;
    private static ProductController productController;
    private static ProductServiceImpl productServiceImpl;
    private static ProductDaoImpl productDaoImpl;
    private static MenuView menuView;
    private static ProductDatabase productDatabase;

    public static Scanner scanner(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
    public static ProductController productController(){
        if(productController == null){
            productController = new ProductController();
        }
        return productController;
    }
    public static MenuController menuController(){
        if(menuController == null){
            menuController = new MenuController();
        }
        return menuController;
    }

    public static ProductServiceImpl productServiceImpl(){
        if(productServiceImpl == null){
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }

    public static ProductDaoImpl productDaoImpl(){
        if(productDaoImpl == null){
            productDaoImpl = new ProductDaoImpl();
        }
        return productDaoImpl;
    }
    public static MenuView menuView(){
        if(menuView == null){
            menuView = new MenuView();
        }
        return menuView;
    }

    public static ProductDatabase productDatabase(){
        if(productDatabase == null){
            productDatabase = new ProductDatabase();
        }
        return productDatabase;
    }


}
