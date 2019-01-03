package com.adifier.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @description: create not found exception
 * @author: StevenWu
 * @create: 2019-01-03 15:22
 **/
@ResponseStatus(HttpStatus.NOT_FOUND)
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
