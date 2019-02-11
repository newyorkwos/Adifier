package com.adifier.resource;

/**
 * 描述:
 * create Invalid Error Class
 *
 * @author StevenWu
 * @create 2019-02-06-23:02
 */
public class InvalidErrorResource {

    private String message;
    private Object errors;

    public InvalidErrorResource(String message, Object errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public Object getErrors() {
        return errors;
    }
}
