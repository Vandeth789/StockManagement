package com.vanndeth.exception;

public class ProductCodeNotFoundException extends RuntimeException{

    public ProductCodeNotFoundException(String message){
        super(message);
    }
}
