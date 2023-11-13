package com.vanndeth.model;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private Long code;
    private String Name;
    private Double price;
    private Integer qty;
    private LocalDate importedDate;
    public Product(){

    }
    public Product(Long code, String name, Double price, Integer qty, LocalDate importedDate) {
        this.code = code;
        Name = name;
        this.price = price;
        this.qty = qty;
        this.importedDate = importedDate;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public LocalDate getImportedDate() {
        return importedDate;
    }

    public void setImportedDate(LocalDate importedDate) {
        this.importedDate = importedDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "proCode=" + code +
                ", Name='" + Name + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", importDate=" + importedDate +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getCode().equals(product.getCode()) && getName().equals(product.getName()) && getPrice().equals(product.getPrice()) && getQty().equals(product.getQty()) && getImportedDate().equals(product.getImportedDate());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getPrice(), getQty(), getImportedDate());
    }
}
