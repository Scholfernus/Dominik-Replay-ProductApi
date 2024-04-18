package com.example.products.utils.Error;

public class ProductNotFoundException extends RuntimeException {
    public static String exceptionMessage = "Product doesn't exists";
    public ProductNotFoundException(String message) {
        exceptionMessage = message.toLowerCase();
    }
}
