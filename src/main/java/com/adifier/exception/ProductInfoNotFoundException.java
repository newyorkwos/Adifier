package com.adifier.exception;

/**
 * @description: create not found exception
 * @author: StevenWu
 * @create: 2019-01-03 15:22
 **/

public class ProductInfoNotFoundException extends RuntimeException {

    public ProductInfoNotFoundException() {
    }

    public ProductInfoNotFoundException(String message) {
        super(message);
    }

    public ProductInfoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
