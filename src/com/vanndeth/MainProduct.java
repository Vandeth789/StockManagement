package com.vanndeth;

import com.vanndeth.model.Product;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.vanndeth.utils.FeatureUtil.*;

public class MainProduct {
    public static void main(String[] args) {
        logo();
        List<Product> products = new ArrayList<>();
        products.add(new Product(1 , "Coca", 2000.00, 10, LocalDate.now()));
        products.add(new Product(2 , "Dutch Mill", 6000.00, 15, LocalDate.now()));
        products.add(new Product(3 , "Tiger", 2500.00, 25, LocalDate.now()));
        products.add(new Product(4 , "Coca", 2000.00, 10, LocalDate.now()));
        products.add(new Product(5, "Dutch Mill", 6000.00, 15, LocalDate.now()));
        products.add(new Product(6 , "Tiger", 2500.00, 25, LocalDate.now()));

        Scanner sc=new Scanner(System.in);
        int rowPerPage = 2;
        int currentPage = 1;
        int a;
        do {
            option();
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
                    System.out.println();
                }
                case "U" -> {
                    System.out.println("Update");
                }
                case "D" -> {
                    System.out.println("Delete");
                }
                case "F" -> {
                    System.out.println("First");
                    first(products,rowPerPage,currentPage);
                }
                case "P" -> {
                    System.out.println("Previous");
                    previous(products,rowPerPage,currentPage);
                }
                case "N" -> {
                    next(products,rowPerPage,currentPage);
                }
                case "L" -> {
                    System.out.println("Last");
                    last(products,rowPerPage,currentPage);
                }
                case "S" -> {
                    System.out.println("Search");
                    System.out.println("Search by product's name: ");
                    String sName = sc.nextLine();
                    for (Product product : products) {
                        if (sName.equals(product)) {
                            
                        }
                    }
                }
                case "G" -> {
                    System.out.println("Goto");
                }case "SE" -> {
                    System.out.print("Please enter record for display: ");
                    int record = Integer.parseInt(sc.nextLine());
                    setRecord(products, rowPerPage,currentPage,record);
                    rowPerPage = record;
                }
                case "H" -> {
                    helper();
                }
                case "E" -> {
                    exit();
                }
                default -> {
                    System.out.println("Please enter option above...");
                }
            }
        } while (true);
    }
}
