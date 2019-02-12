package com.adifier.exception;

/**
 * @description: create not found exception
 * @author: StevenWu
 * @create: 2019-01-03 15:22
 **/

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
