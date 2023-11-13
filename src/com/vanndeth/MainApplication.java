package com.vanndeth;

import com.vanndeth.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.vanndeth.utils.FeatureUtil.*;
import static com.vanndeth.utils.Utils.logo;
import static com.vanndeth.utils.Utils.message;

public class MainProduct {
    public static void main(String[] args) {
        logo();
        List<Product> products = new ArrayList<>();
        products.add(new Product(1 , "Coca", 2000.00, 10, LocalDate.of(2022,9,9)));
        products.add(new Product(2 , "Dutch Mill", 8000.00, 25, LocalDate.of(2023,8,8)));
        products.add(new Product(3 , "Tiger", 2500.00, 15, LocalDate.now()));
        products.add(new Product(4 , "Anchor", 2300.00, 10, LocalDate.now()));
        products.add(new Product(5, "Vital", 1000.00, 50, LocalDate.now()));
        products.add(new Product(6 , "Tiger", 2500.00, 15, LocalDate.now()));
        Scanner sc=new Scanner(System.in);
        int rowPerPage = 2;
        int currentPage = 1;
        do {
            Utils.option();
            System.out.print("Command ———> ");
            String option=sc.nextLine();
            switch (option.toUpperCase()){
                case "*" -> {
                    display(products, rowPerPage, currentPage);
                }
                case "W" -> {
                    write(products);
                }
                case "R" -> {
                    read(products);
                }
                case "U" -> {
                    update(products);
                }
                case "D" -> {
                    delete(products);
                }
                case "F" -> {
                    currentPage = first(products,rowPerPage,currentPage);
                }
                case "P" -> {
                    currentPage = previous(products,rowPerPage,currentPage);
                }
                case "N" -> {
                    currentPage = next(products,rowPerPage,currentPage);
                }
                case "L" -> {
                    currentPage = last(products,rowPerPage,currentPage);
                }
                case "S" -> {
                    search(products, rowPerPage, currentPage);
                }
                case "G" -> {
                    currentPage = gotoPage(products,rowPerPage,currentPage);
                }case "SE" -> {
                    rowPerPage = setRecord();
                }
                case "H" -> {
                    helper();
                }
                case "E" -> {
                    exit();
                }
                default -> {
                    String[] shortcut = option.split("#");
                    switch (shortcut[0].toUpperCase()){
                        case "W" -> {
                            ShortcutUtil.write(products,shortcut);
                        }
                        case "R" -> {
                            ShortcutUtil.read(products, shortcut);
                        }
                        case "D" -> {
                            ShortcutUtil.delete(products, shortcut);
                        }
                        default -> {
                            message("Please choose option above: ");
                        }
                    }
                }
            }
        } while (true);
    }
}
