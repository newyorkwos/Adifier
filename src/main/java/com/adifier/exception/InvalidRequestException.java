package com.adifier.exception;

import org.springframework.validation.Errors;

/**
 * @description: create Invalid Request Exception
 * @author: StevenWu
 * @create: 2019-01-17 16:33
 **/

public class InvalidRequestException extends RuntimeException{

    private Errors  errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }
}
